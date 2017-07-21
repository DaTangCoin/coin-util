package com.datang.coin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

	public static void updateCoin(String coinGroup, Coin coin) {
		Call<ResponseBody> response = service.updateCoin(coinGroup, coin.getObjectId(), coin);
		try {
			Response<ResponseBody> r = response.execute();
			if (r.isSuccessful()) {
				System.out.println("Successfully updated the coin to the database: " + r.message());
			} else {
				System.out.println("Failed to update the coin to the database. " + r.code());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static CoinResult getCoin(String coinGroup, String coinId) {
		final String coinWhereQueryStr = "{\"id\":\"" + coinId + "\"}";
		Call<CoinResult> response = service.getCoin(coinGroup, coinWhereQueryStr);
		try {
			Response<CoinResult> r = response.execute();
			if (r.isSuccessful()) {
				System.out.println("Successfully get the coin from the database: " + r.message());
				return r.body();
			} else {
				System.out.println("Failed to get the coin from the database. " + r.code());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main( String[] args ) throws ParseException {
		service = retrofit.create(ParseService.class);

		uploadData();
		//updateCoinPrice("1982PGC10");


	}

	public static void  uploadData() throws ParseException{
		// TODO: Parse all your coins and call this method to insert them all to the database
		// create all your coins
		try {

            File f = new File("C:\\Users\\Alfred&Iris\\Desktop\\PandaGoldCoin.txt");

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
            	c.setPriceUrl(temp[9]);
            	c.setImageUrlLarge("http://picsforcoin.oss-us-west-1.aliyuncs.com/emptycoin/emptycoinstandard.png");
            	c.setImageUrlSmall("http://picsforcoin.oss-us-west-1.aliyuncs.com/emptycoin/emptycoinsmall.png");
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
	
	public static void updateCoinPrice(String id){
		ArrayList<Coin> list = new ArrayList<Coin>();
		list = (ArrayList<Coin>) getCoin("coin12",id).getResults();
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
			PriceUrl url = new PriceUrl(list.get(i).getPriceUrl());
			try {
				list.get(i).setPrice(url.Price());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list.get(i));
			updateCoin("coin12",list.get(i));
		}
	}
	
	
	public static void updateCoinUrl(String id, String url){
		ArrayList<Coin> list = new ArrayList<Coin>();
		list = (ArrayList<Coin>) getCoin("coin12",id).getResults();
		for(int i=0; i<list.size();i++){
			list.get(i).setImageUrlLarge(url);;
			System.out.println(list.get(i));
			updateCoin("coin12",list.get(i));
		}
	}
}
