package com.datang.coin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ParseService {

	@POST("classes/coin3")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<ResponseBody> createCoin(@Body Coin coin);

	@PUT("classes/coin/{coinId}")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<ResponseBody> updateCoin(@Path("coinId") String coinId, @Body Coin coin);

	@PUT("classes/coin/{coinId}")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<ResponseBody> getCoin(@Path("coinId") String coinId);
}
