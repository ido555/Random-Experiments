package com.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.beans.Stock;
import com.example.services.WebClientHelper;

@SpringBootApplication
public class StocksProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksProjectApplication.class, args);
		WebClientHelper helper = new WebClientHelper();
		Stock stock = helper.getStock("SPCE", "full");
//		/Stocks_Project/src/main/resources/static
		try {
			
			FileOutputStream fout = new FileOutputStream("C:\\Users\\Shmoozel\\git\\Programming_05.05.2020_and_on\\Stocks_Project\\src\\main\\resources\\static\\SPCE.Stock");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(stock);
			oos.close();
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
//		System.out.println(helper.getStock("AMZN", "compact"));
//		System.out.println(helper.getStock("FB", "compact"));
//		System.out.println(helper.getStock("TSLA", "compact"));
	}
}
