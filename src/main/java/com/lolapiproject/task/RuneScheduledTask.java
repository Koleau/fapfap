package com.lolapiproject.task;

import com.lolapiproject.bean.Rune;
import com.lolapiproject.bean.Version;
import com.lolapiproject.repository.RuneRepository;
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
public class RuneScheduledTask {

    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    private RuneRepository runeRepository;

    @Value("${apikey}")
    private String apiKey;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(cron = "0 0 2 1/1 * *")//TODO: chech le cron
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void updateRuneDB() {
        // TODO: change par logger
        System.out.println("Update rune collection started at : " + dateFormat.format(new Date()));

        // Get current version stored
        Version version = versionRepository.findByCollection("rune");

        // Request to get current version
        LolAPIGlobalService lolAPIGlobalService = RetrofitUtils.buildLolAPIServiceGlobal();
        Call<Map<String, Object>> call2 = lolAPIGlobalService.getRuneList(apiKey);
        Response<Map<String, Object>> response2 = null;
        try {
            response2 = call2.execute();
        } catch (IOException e) {
            // TODO: rajouter logger et message d'erreur
            e.printStackTrace();
            // TODO: change par logger
            System.out.println("Upsate rune collection failed at : " + dateFormat.format(new Date()));
            return;
        }
        // Current version
        String apiVersion = (String) response2.body().get("version");

        // if none or different -> update
        if (version == null || !apiVersion.equals(version.getVersion())) {
            Map runeMap = (Map) response2.body().get("data");
            ArrayList<Rune> runes = new ArrayList<>();
            for (Object map : runeMap.values()) {
                runes.add(Rune.linkedHashMapToRune((LinkedHashMap)map));
            }
            runeRepository.save(runes);
            // Update version
            if  (version == null) {
                version = new Version();
                version.setCollection("rune");
                // TODO: change par logger
                System.out.println("Creation rune collection at : " + dateFormat.format(new Date()));
            }
            // TODO: change par logger
            System.out.println("Upsate rune collection to "+ apiVersion + " at : " + dateFormat.format(new Date()));
            version.setVersion(apiVersion);
            versionRepository.save(version);
        } else {
            // TODO: change par logger
            System.out.println("Already up to date : " + dateFormat.format(new Date()));
        }

    }
}
