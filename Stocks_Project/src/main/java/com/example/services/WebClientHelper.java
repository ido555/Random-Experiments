package com.example.services;

import com.example.DatasetSize;
import com.example.beans.Stock;
import com.example.beans.StockDataPoint;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class WebClientHelper {
    private static WebClient client = WebClient.builder()
            .exchangeStrategies(ExchangeStrategies.builder()
                    .codecs(configurer -> configurer.defaultCodecs()
                            // 16 MBs instead of the default 256KB.
                            // needed for larger json files
                            .maxInMemorySize(16 * 1024 * 1024))
                    .build())
            .build();

    public WebClientHelper() {
    }

    /**
     * @param symbol - stock ticker. example FB , GOOGL , AMZN , TSLA
     * @param size   - DatasetSize enum
     * @return
     */
    public Stock getStock(String symbol, DatasetSize size) {
        Mono<ResponseEntity<String>> monoJson = client.get()
                .uri("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&outputsize=" + size + "&apikey=1P1K8X19J70V85OJ")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class);
        Gson gson = new Gson();

        // TODO fix this mess
        // TODO handle NullPointer because of api limit exceeded returning i dont even know what... (need an error callback)
        // synchronously(with block() )(good enough for now) subscribe to monoJson then
        // unwrap Mono then using getBody unwrap ResponseEntity
        // whats left is a JSON object array in a string
        // turn that string into a Gson JsonObject
        JsonObject dataset = (JsonObject) gson.fromJson(monoJson.block().getBody(), JsonObject.class)
                .get("Time Series (Daily)");


        Set<Entry<String, JsonElement>> set;
        try {
            set = dataset.entrySet();
        } catch (NullPointerException e) {
            return null;
        }

        Double maxPrice = 0D, minPrice = Double.MAX_VALUE;
        List<StockDataPoint> dataPoints = new ArrayList<StockDataPoint>();
        for (Entry<String, JsonElement> entry : set) {
            Date date = Date.valueOf(entry.getKey());
            Double open = ((JsonObject) entry.getValue()).get("1. open").getAsDouble();
            Double high = ((JsonObject) entry.getValue()).get("2. high").getAsDouble();
            Double low = ((JsonObject) entry.getValue()).get("3. low").getAsDouble();

            // find out what the highest and lowest prices were
            if (high > maxPrice) {
                maxPrice = high;
            }
            if (low < minPrice) {
                minPrice = low;
            }

            Double close = ((JsonObject) entry.getValue()).get("4. close").getAsDouble();
            Long volume = ((JsonObject) entry.getValue()).get("5. volume").getAsLong();
            dataPoints.add((new StockDataPoint(date, open, high, low, close, volume)));
        }
        // TODO calculate maxPrice and minPrice in frontend to prevent "server" overload
        // add 10% to lowest low and highest high ( helps make the graph look better )
        minPrice = minPrice * 0.9;
        maxPrice = maxPrice * 1.1;
        Stock stock = new Stock(dataPoints, maxPrice, minPrice);
        return stock;
    }
}
