package com.example.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stock implements Serializable{
	List<StockDataPoint> dataPoints = new ArrayList<StockDataPoint>();
	
	public void addDataPoint(StockDataPoint dataPoint) {
		dataPoints.add(dataPoint);
	}

	@Override
	public String toString() {
		return "Stock [dataPoints=" + dataPoints + "]";
	}

	public List<StockDataPoint> getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(List<StockDataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
}
