package com.datang.coin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.parse4j.ParseException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class App {

	private static Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://47.89.253.52:1337/parse/")
			.addConverterFactory(JacksonConverterFactory.create())
			.build();

	private static ParseService service;

	public static void insertCoin(Coin coin) {
		Call<ResponseBody> response = service.createCoin(coin);
		try {
			Response<ResponseBody> r = response.execute();
			if (r.isSuccessful()) {
				System.out.println("Successfully inserted the coin to the database: " + r.message());
			} else {
				System.out.println("Failed to insert the coin to the database. " + r.code());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main( String[] args ) throws ParseException {
		service = retrofit.create(ParseService.class);

		// TODO: Parse all your coins and call this method to insert them all to the database
		// create all your coins
		 try {

	            File f = new File("C:\\Users\\Alfred&Iris\\Desktop\\PandaCoin.txt");

	            BufferedReader b = new BufferedReader(new FileReader(f));

	            String readLine = "";

	            System.out.println("Reading file using Buffered Reader");

	            while ((readLine = b.readLine()) != null) {
	            	Coin c = new Coin();
	        		
	            	String[] temp = readLine.split(",");
	            	c.setId(temp[0]);
	            	c.setName(temp[1]);
	            	c.setYear(temp[2]);
	            	c.setSize(temp[3]);
	            	c.setPrice(temp[4]);
	            	c.setPrice68(temp[5]);
	            	c.setPrice69(temp[6]);
	            	c.setPrice70(temp[7]);
	            	c.setQuantity(temp[8]);
	        		insertCoin(c);
	            	readLine.split(",");
	            	System.out.println(readLine);
	            	for(int i = 0;i<9;i++){
	            		System.out.println(temp[i]);
	            	}
	                
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		

		// insert the coin to the database
		
	}

}
