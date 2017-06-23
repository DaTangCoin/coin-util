package com.datang.coin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ParseService {

	@POST("classes/coin")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<ResponseBody> createCoin(@Body Coin coin);
}
