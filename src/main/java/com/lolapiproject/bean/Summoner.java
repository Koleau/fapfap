package com.lolapiproject.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Pflieger on 22/04/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Summoner {


    private String id;
    private String name;
    private int summonerLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public Summoner(String id, String name, int summonerLevel) {
        this.id = id;
        this.name = name;
        this.summonerLevel = summonerLevel;
    }

    public Summoner() {
    }
}
