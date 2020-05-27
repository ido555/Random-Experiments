package com.example.beans;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonObject;

public class StockDataPoint {
	private Date dataPointDate;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Long volume;
	
	public StockDataPoint(Date dataPointDate, Double open, Double high, Double low, Double close, Long volume) {
		this.dataPointDate = dataPointDate;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StockDataPoint [dataPointDate=" + dataPointDate + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", volume=" + volume + "]";
	}
	
	
	
}
