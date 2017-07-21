package com.datang.coin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ParseService {

	@POST("classes/coin13")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<ResponseBody> createCoin(@Body Coin coin);

	@PUT("classes/{coinGroup}/{objectId}")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<ResponseBody> updateCoin(@Path("coinGroup") String coinGroup, @Path("objectId") String objectId, @Body Coin coin);

	@GET("classes/{coinGroup}")
	@Headers({
	    "X-Parse-Application-Id: coin",
	    "Content-Type: application/json"
	})
	Call<CoinResult> getCoin(@Path("coinGroup") String coinGroup, @Query("where") String queryString);
}
