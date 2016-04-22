package com.lolapiproject.controllers;

import com.lolapiproject.Const;
import com.lolapiproject.Service.TestAPIService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * Created by Pflieger on 21/04/2016.
 */

@Controller
@RequestMapping("/lolapi")
public class LolAPIRequest {

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> requestLolAPPI() {

        HttpHeaders httpHeaders = new HttpHeaders();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("https://euw.api.pvp.net")
                .build();

        TestAPIService testAPIService = retrofit.create(TestAPIService.class);

        Call<Object> call = testAPIService.getSummonerByName("jouaoutch", Const.API_KEY);

        Response<Object> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(response.body(), httpHeaders, HttpStatus.OK);
    }

}
