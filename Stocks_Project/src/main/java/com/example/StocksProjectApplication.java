package com.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.beans.Test;
import com.google.gson.Gson;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class StocksProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksProjectApplication.class, args);
		// testing
		WebClient client = WebClient.create("https://www.quandl.com");
		Gson gson = new Gson();
		
		// idk wtf Mono or Flux are
		Mono<ResponseEntity<String>> monoJson = client.get()
				.uri("/api/v3/datasets/WIKI/FB/data.json?api_key=mjx-P5DxGK8a3vBcRUT_")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(String.class);
		// synchronously subscribe to monoJson then unwrap Mono
		// then using getBody unwrap ResponseEntity
		String stringJson = monoJson.block().getBody();
		System.out.println(stringJson);
		System.out.println( gson.fromJson(stringJson, Test.class));
//		System.out.println(test);
	}

}
