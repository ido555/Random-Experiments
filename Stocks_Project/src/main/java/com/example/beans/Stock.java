package com.example.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stock implements Serializable{
	private List<StockDataPoint> dataPoints = new ArrayList<StockDataPoint>();
	private Double maxPrice;
	private Double minPrice;
	
	public Stock(List<StockDataPoint> dataPoints, double maxPrice, double minPrice) {
		this.dataPoints = dataPoints;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
	}

	public List<StockDataPoint> getDataPoints() {
		return dataPoints;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setDataPoints(List<StockDataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	
	
	
}
