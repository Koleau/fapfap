package com.lolapiproject.Service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Pflieger on 21/04/2016.
 */
public interface TestAPIService {

    @GET("/api/lol/euw/v1.4/summoner/by-name/{summonerNames}")
    Call<Object> getSummonerByName(@Path("summonerNames") String summoner, @Query("api_key") String key);

}
