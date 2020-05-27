package com.example.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.example.beans.Stock;

import reactor.core.publisher.Mono;



public class WebClientHelper {
	public WebClient client;

	public WebClientHelper() {
//		https://www.quandl.com/api/v3/datasets/WIKI/FB/data.json?api_key=mjx-P5DxGK8a3vBcRUT_
		client = WebClient.create("https://www.quandl.com");
		Mono<ResponseEntity<Stock>> request = client.get()
				.uri("/api/v3/datasets/WIKI/FB/data.json?api_key=mjx-P5DxGK8a3vBcRUT_")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(Stock.class);	
	}
}
