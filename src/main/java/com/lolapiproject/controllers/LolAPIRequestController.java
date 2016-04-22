package com.lolapiproject.controllers;

import com.lolapiproject.Const;
import com.lolapiproject.service.LolAPIService;
import com.lolapiproject.utils.RetrofitUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by Pflieger on 21/04/2016.
 */

@Controller
@RequestMapping("/lolapi")
public class LolAPIRequestController {

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> requestLolAPI() {

        HttpHeaders httpHeaders = new HttpHeaders();



        LolAPIService lolAPIService = RetrofitUtils.buildLolAPIService();

        Call<Object> call = lolAPIService.getSummonerByName("jouaoutch", Const.API_KEY);

        Response<Object> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(response.body(), httpHeaders, HttpStatus.OK);
    }

}
