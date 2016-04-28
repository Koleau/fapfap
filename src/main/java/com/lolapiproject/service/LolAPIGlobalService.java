package com.lolapiproject.service;

import com.lolapiproject.bean.Rune;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Map;

/**
 * Created by Pflieger on 26/04/2016.
 */
public interface LolAPIGlobalService {

    @GET("/api/lol/static-data/euw/v1.2/rune")
    Call<Map<String, Object>> getRuneList(@Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/rune/{id}")
    Call<Object> getRuneByRuneId(@Path("id") String id, @Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/champion")
    Call<Map<String, Object>> getChampionList(@Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/champion/{id}")
    Call<Object> getChampionById(@Path("id") String id, @Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/mastery")
    Call<Object> getMasteryList(@Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/mastery/{id}")
    Call<Object> getMasteryByMasteryId(@Path("id") String id, @Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/summoner-spell")
    Call<Object> getSummonerSpellList(@Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/summoner-spell/{id}")
    Call<Object> getSummonerSpellById(@Path("id") String id, @Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/item")
    Call<Object> getItemList(@Query("api_key") String key);

    @GET("/api/lol/static-data/euw/v1.2/item/{id}")
    Call<Object> getItemById(@Path("id") String id, @Query("api_key") String key);
}
