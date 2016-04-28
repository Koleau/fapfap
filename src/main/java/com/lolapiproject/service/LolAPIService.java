package com.lolapiproject.service;

import com.lolapiproject.bean.Summoner;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Map;

public interface LolAPIService {

    @GET("/api/lol/euw/v1.4/summoner/by-name/{summonerNames}")
    Call<Map<String, Summoner>> getSummonerByName(@Path("summonerNames") String summoner, @Query("api_key") String key);

    @GET("/api/lol/euw/v2.2/matchlist/by-summoner/{summonerId}")
    Call<Object> getMatchListBySummonerId(@Path("summonerId") String summonerId, @Query("api_key") String key);

    @GET("/api/lol/euw/v1.3/stats/by-summoner/{summonerId}/ranked")
    Call<Object> getRankedStatsBySummonerId(@Path("summonerId") String summonerId, @Query("api_key") String key);

    @GET("/api/lol/euw/v1.3/stats/by-summoner/{summonerId}/summary")
    Call<Object> getSummaryStatsBySummonerId(@Path("summonerId") String summonerId, @Query("api_key") String key);

    @GET("/api/lol/euw/v1.4/summoner/{summonerIds}/runes")
    Call<Object> getRunesBySummonerId(@Path("summonerId") String summonerId, @Query("api_key") String key);

    @GET("/api/lol/euw/v1.4/summoner/{summonerIds}/masteries")
    Call<Object> getMasteriesBySummonerId(@Path("summonerId") String summonerId, @Query("api_key") String key);

    @GET("/api/lol/euw/v2.4/team/by-summoner/{summonerIds}")
    Call<Object> getTeamsBySummonerId(@Path("summonerId") String summonerId, @Query("api_key") String key);

    @GET("/api/lol/euw/v2.4/team/{teamIds}")
    Call<Object> getTeamByTeamId(@Path("teamIds") String teamIds, @Query("api_key") String key);

}
