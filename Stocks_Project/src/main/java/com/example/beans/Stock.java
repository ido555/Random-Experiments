package com.example.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stock {
	List<StockDataPoint> dataPoints = new ArrayList<StockDataPoint>();
	
	public void addDataPoint(StockDataPoint dataPoint) {
		dataPoints.add(dataPoint);
	}

	@Override
	public String toString() {
		return "Stock [dataPoints=" + dataPoints + "]";
	}
	
}
