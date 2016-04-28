package com.lolapiproject.task;

import com.lolapiproject.bean.Champion;
import com.lolapiproject.bean.Rune;
import com.lolapiproject.bean.Version;
import com.lolapiproject.repository.ChampionRepository;
import com.lolapiproject.repository.VersionRepository;
import com.lolapiproject.service.LolAPIGlobalService;
import com.lolapiproject.utils.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Pflieger on 27/04/2016.
 */
@Component
public class ChampionScheduledTask {

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Value("${apikey}")
    private String apiKey;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//        @Scheduled(initialDelay = 1000, fixedRate = 5000)
    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void updateChampionDB() {
        // TODO: change par logger
        System.out.println("Update champion collection started at : " + dateFormat.format(new Date()));

        // Get current version stored
        Version version = versionRepository.findByCollection("champion");

        // Request to get current version
        LolAPIGlobalService lolAPIGlobalService = RetrofitUtils.buildLolAPIServiceGlobal();
        Call<Map<String, Object>> call2 = lolAPIGlobalService.getChampionList(apiKey);
        Response<Map<String, Object>> response2 = null;
        try {
            response2 = call2.execute();
        } catch (IOException e) {
            // TODO: rajouter logger et message d'erreur
            e.printStackTrace();
            // TODO: change par logger
            System.out.println("Upsate champion collection failed at : " + dateFormat.format(new Date()));
            return;
        }
        // Current version
        String apiVersion = (String) response2.body().get("version");

        // if none or different -> update
        if (version == null || !apiVersion.equals(version.getVersion())) {
            Map championMap = (Map) response2.body().get("data");
            ArrayList<Champion> champions = new ArrayList<>();
            for (Object map : championMap.values()) {
                champions.add(Champion.linkedHashMapToChampion((LinkedHashMap)map));
            }
            championRepository.save(champions);
            // Update version
            if  (version == null) {
                version = new Version();
                version.setCollection("champion");
                // TODO: change par logger
                System.out.println("Creation champion collection at : " + dateFormat.format(new Date()));
            }
            // TODO: change par logger
            System.out.println("Upsate champion collection to "+ apiVersion + " at : " + dateFormat.format(new Date()));
            version.setVersion(apiVersion);
            versionRepository.save(version);
        } else {
            // TODO: change par logger
            System.out.println("Champion already up to date : " + dateFormat.format(new Date()));
        }

    }

}
