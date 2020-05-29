package com.example.beans;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class StockDataPoint implements Serializable{
//	@SerializedName - when gson turns this object a json object the key will be called whatever value
	@SerializedName(value = "t")
	private Long epochDate;
	@SerializedName(value = "o")
	private Double open;
	@SerializedName(value = "h")
	private Double high;
	@SerializedName(value = "l")
	private Double low;
	@SerializedName(value = "c")
	private Double close;
	private Long volume;
	
	public StockDataPoint(Long epochDate, Double open, Double high, Double low, Double close, Long volume) {
		this.epochDate = epochDate;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StockDataPoint [epochDate=" + epochDate + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", volume=" + volume + "]";
	}

	public Long getDataPointDate() {
		return epochDate;
	}

	public Double getOpen() {
		return open;
	}

	public Double getHigh() {
		return high;
	}

	public Double getLow() {
		return low;
	}

	public Double getClose() {
		return close;
	}

	public Long getVolume() {
		return volume;
	}

	public void setDataPointDate(Long dataPointDate) {
		this.epochDate = dataPointDate;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}
	
	
	
}
