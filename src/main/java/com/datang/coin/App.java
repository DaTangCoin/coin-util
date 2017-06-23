package com.datang.coin;

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
		Coin c = new Coin();
		c.setName("FFF2");

		// insert the coin to the database
		insertCoin(c);
	}

}
