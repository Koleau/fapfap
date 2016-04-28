package com.lolapiproject.controllers;

import com.lolapiproject.bean.Champion;
import com.lolapiproject.repository.RuneRepository;
import com.lolapiproject.service.LolAPIGlobalService;
import com.lolapiproject.utils.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/lolapi")
public class LolAPIRequestController {

    @Value("${apikey}")
    private String apiKey;

    @Autowired
    private RuneRepository runeRepository;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> requestLolAPI() {
        HttpHeaders httpHeaders = new HttpHeaders();
        LolAPIGlobalService lolAPIGlobalService = RetrofitUtils.buildLolAPIServiceGlobal();
        Call<Map<String, Object>> call2 = lolAPIGlobalService.getChampionList(apiKey);
        Response<Map<String, Object>> response2 = null;
        try {
            response2 = call2.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map heroMap = (Map) response2.body().get("data");
        List<Champion> champions = new ArrayList<>();
        for (Object o : heroMap.values()) {
            champions.add(Champion.linkedHashMapToChampion((LinkedHashMap) o));
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }



}
