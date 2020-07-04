package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.beans.Stock;
import com.example.beans.StockDataPoint;
import com.example.services.WebClientHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@SpringBootApplication
public class StocksProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksProjectApplication.class, args);
//		WebClientHelper helper = new WebClientHelper();
//		Stock stock = helper.getStock("SPCE", "compact");
//		System.out.println(stock.getDataPoints());
//		Gson gson = new Gson();
//		JsonArray jsonArray = gson.toJsonTree(stock.getDataPoints()).getAsJsonArray();
//		System.out.println(jsonArray.toString());

//		System.out.println("done");
//		System.out.println(helper.getStock("AMZN", "compact"));
//		System.out.println(helper.getStock("FB", "compact"));
//		System.out.println(helper.getStock("TSLA", "compact"));
	}
}
///Stocks_Project/src/main/resources/static
//try {
//	
//	FileOutputStream fout = new FileOutputStream("C:\\Users\\Shmoozel\\git\\Programming_05.05.2020_and_on\\Stocks_Project\\src\\main\\resources\\static\\SPCE.Stock");
//	ObjectOutputStream oos = new ObjectOutputStream(fout);
//	oos.writeObject(stock);
//	oos.close();
//	fout.close();
//	FileInputStream fin = new FileInputStream("C:\\Users\\Shmoozel\\git\\Programming_05.05.2020_and_on\\Stocks_Project\\src\\main\\resources\\static\\SPCE.Stock");
//	ObjectInputStream ois = new ObjectInputStream(fin);
//	Stock stock1 = (Stock) ois.readObject();
//	System.out.println(stock);
//	fin.close();
//	ois.close();
//} catch (IOException | ClassNotFoundException e) {
//	// 
//	e.printStackTrace();
//}
