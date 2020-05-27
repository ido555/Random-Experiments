package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.services.WebClientHelper;

@SpringBootApplication
public class StocksProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksProjectApplication.class, args);
		WebClientHelper helper = new WebClientHelper();
		System.out.println( helper.getStock("FB", "compact"));
		System.out.println( helper.getStock("AMZN", "compact"));
		System.out.println( helper.getStock("TSLA", "compact"));
//		WebClient client = WebClient.builder()
//				.exchangeStrategies(ExchangeStrategies.builder()
//						.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
//				.build();
//		Gson gson = new Gson();
//		Mono<ResponseEntity<String>> monoJson = client.get()
//				.uri("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=FB&outputsize=full&apikey=1P1K8X19J70V85OJ")
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.toEntity(String.class);
//		// synchronously(good enough for now) subscribe to monoJson then unwrap Mono
//		// then using getBody unwrap ResponseEntity
//		// whats left is a JSON formatted String
//		// turn that string into a Gson JsonObject
//		JsonObject dataset = (JsonObject) gson.fromJson(monoJson.block().getBody(), JsonObject.class)
//				.get("Time Series (Daily)");
//		Set<Entry<String, JsonElement>> set = dataset.entrySet();
//		Stock stock1 = new Stock();
//		for (Entry<String, JsonElement> entry : set) {
//			Date dataPointDate = java.sql.Date.valueOf(entry.getKey());
//			Double open = ((JsonObject) entry.getValue()).get("1. open").getAsDouble();
//			Double high = ((JsonObject) entry.getValue()).get("2. high").getAsDouble();
//			Double low = ((JsonObject) entry.getValue()).get("3. low").getAsDouble();
//			Double close = ((JsonObject) entry.getValue()).get("4. close").getAsDouble();
//			Long volume = ((JsonObject) entry.getValue()).get("5. volume").getAsLong();
//			stock1.addDataPoint(new StockDataPoint(dataPointDate, open, high, low, close, volume));
//		}
//		System.out.println(stock1);
	}

//		 System.out.println(json2.has("dataset_data"));
//		 System.out.println(dataset.has("column_names"));
//		 System.out.println(dataset.get("column_names"));
//		 System.out.println(dataset.get("start_date"));
//		 System.out.println(dataset.get("data"));
//		JsonArray data = (JsonArray) dataset.get("data");
//		for (int i = 0; i < data.size(); i++) {
////			JsonObject obj = null;
//			System.out.println(data.get(i));
//		}

//		System.out.println(json2.getAsJsonObject("StockDataPoint"));
//		System.out.println(gson.fromJson(json2, Stock.class));
}
