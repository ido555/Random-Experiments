package com.example.controllers;

import com.example.DatasetSize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.beans.Stock;
import com.example.services.WebClientHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
	@GetMapping("/getStock/{symbol}/{size}")
	// TODO replace String-y code for 'size' with Enum-y code
	public String getStock(@PathVariable String symbol, @PathVariable DatasetSize size){
		if (!(size.equals("full") || size.equals("compact"))) {
			System.out.println("a valid size is either 'full' or 'compact'. set to compact ");
			size = DatasetSize.compact;
		}
		System.out.println("controller request");
		WebClientHelper helper = new WebClientHelper();
		Stock stock = helper.getStock(symbol, size);
//		if (stock == null) {
//			return "5 requests per minute or 500 requests per day were exceeded for this api key";
//		}
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();
		JsonObject maxMinPrice = new JsonObject();
		maxMinPrice.addProperty("maxPrice", stock.getMaxPrice()*1.1);
		maxMinPrice.addProperty("minPrice", stock.getMinPrice()*0.9);
		jsonArray.add(maxMinPrice);
		jsonArray.addAll(gson.toJsonTree(stock.getDataPoints()).getAsJsonArray());
		
		return  jsonArray.toString();
	}

}
//https://www.quandl.com/api/v3/datasets/WIKI/FB/data.json?api_key=mjx-P5DxGK8a3vBcRUT_