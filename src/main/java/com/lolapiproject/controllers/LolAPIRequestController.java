package com.lolapiproject.controllers;

import com.lolapiproject.bean.Summoner;
import com.lolapiproject.service.LolAPIService;
import com.lolapiproject.utils.RetrofitUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("/lolapi")
public class LolAPIRequestController {

    @Value("${apikey}")
    private String apiKey;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> requestLolAPI() {
        HttpHeaders httpHeaders = new HttpHeaders();
        LolAPIService lolAPIService = RetrofitUtils.buildLolAPIService();
        Call<Map<String, Summoner>> call = lolAPIService.getSummonerByName("koslo", apiKey);
        Response<Map<String, Summoner>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response.body(), httpHeaders, HttpStatus.OK);
    }

}
