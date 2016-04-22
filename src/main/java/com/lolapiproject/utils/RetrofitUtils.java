package com.lolapiproject.utils;

import com.lolapiproject.service.LolAPIService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Pflieger on 22/04/2016.
 */
public class RetrofitUtils {

    public static LolAPIService buildLolAPIService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("https://euw.api.pvp.net")
                .build();
        return retrofit.create(LolAPIService.class);
    }

}
