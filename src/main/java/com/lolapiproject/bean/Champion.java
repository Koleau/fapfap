package com.lolapiproject.bean;

import org.springframework.data.annotation.Id;

import java.util.LinkedHashMap;

/**
 * Created by Pflieger on 27/04/2016.
 */
public class Champion {

    @Id
    private int id;

    private String name;

    private String title;

    public Champion() {
    }

    public Champion(int id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public static Champion linkedHashMapToChampion(LinkedHashMap map) {
        Champion champion = new Champion();
        champion.setTitle((String)map.get("title"));
        champion.setName((String)map.get("name"));
        champion.setId((int)map.get("id"));
        return champion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
