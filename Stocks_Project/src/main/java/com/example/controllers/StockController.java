package com.example.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.beans.Stock;
import com.example.services.WebClientHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
	@GetMapping("/getStock/{symbol}/{size}")
	public String getStock(@PathVariable String symbol, @PathVariable String size){
		if (!(size.equals("full") || size.equals("compact"))) {
			System.out.println("a valid size is either 'full' or 'compact'. set to compact ");
			size = "compact";
		}
		WebClientHelper helper = new WebClientHelper();
		Stock stock = helper.getStock(symbol, size);
		if (stock == null) {
			return "5 requests per minute or 500 requests per day were exceeded for this api key";
		}
		Gson gson = new Gson();
		JsonArray jsonArray = gson.toJsonTree(stock.getDataPoints()).getAsJsonArray();
		return jsonArray.toString();
	}

}
//https://www.quandl.com/api/v3/datasets/WIKI/FB/data.json?api_key=mjx-P5DxGK8a3vBcRUT_