package com.example.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	Date startDate;

	public Test(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Test [startDate=" + startDate + "]";
	}
	
}
