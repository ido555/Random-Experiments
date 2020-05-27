package com.example.services;

import java.util.Date;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.beans.Stock;
import com.example.beans.StockDataPoint;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import reactor.core.publisher.Mono;

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
	 * 
	 * @param symbol - stock ticker. example FB , GOOGL , AMZN , TSLA
	 * @param compactOrFull - must be either 'compact' or 'full'
	 * @return
	 */
	public Stock getStock(String symbol, String compactOrFull) {
		Mono<ResponseEntity<String>> monoJson = client.get()
				.uri("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&outputsize=" + compactOrFull + "&apikey=1P1K8X19J70V85OJ")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(String.class);
		Gson gson = new Gson();
		// synchronously(with block() )(good enough for now) subscribe to monoJson then
		// unwrap Mono then using getBody unwrap ResponseEntity
		// whats left is a JSON formatted String
		// turn that string into a Gson JsonObject
		JsonObject dataset = (JsonObject) gson.fromJson(monoJson.block().getBody(), JsonObject.class)
				.get("Time Series (Daily)");
		Set<Entry<String, JsonElement>> set = dataset.entrySet();
		Stock stock = new Stock();
		for (Entry<String, JsonElement> entry : set) {
			Date dataPointDate = java.sql.Date.valueOf(entry.getKey());
			Double open = ((JsonObject) entry.getValue()).get("1. open").getAsDouble();
			Double high = ((JsonObject) entry.getValue()).get("2. high").getAsDouble();
			Double low = ((JsonObject) entry.getValue()).get("3. low").getAsDouble();
			Double close = ((JsonObject) entry.getValue()).get("4. close").getAsDouble();
			Long volume = ((JsonObject) entry.getValue()).get("5. volume").getAsLong();
			stock.addDataPoint(new StockDataPoint(dataPointDate, open, high, low, close, volume));
		}
		return stock;
	}
}
