package com.example.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.beans.Stock;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
//@CrossOrigin
public class StockController {
//	@GetMapping("/halp")
//	public Mono<ResponseEntity<JSONObject>> getStock(){
//		return null;
//	}

}
//https://www.quandl.com/api/v3/datasets/WIKI/FB/data.json?api_key=mjx-P5DxGK8a3vBcRUT_