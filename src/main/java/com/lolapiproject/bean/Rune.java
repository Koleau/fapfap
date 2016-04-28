package com.lolapiproject.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.LinkedHashMap;

/**
 * Created by Pflieger on 26/04/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Rune {

    @Id
    private int id;

    private String name;

    private String description;

    private boolean isRune;

    private String tier;

    private String type;

    public static Rune linkedHashMapToRune(LinkedHashMap map) {
        Rune rune = new Rune();
        rune.setId((int)map.get("id"));
        rune.setName((String)map.get("name"));
        rune.setDescription((String)map.get("description"));
        LinkedHashMap map2 = (LinkedHashMap) map.get("rune");
        rune.setRune((boolean)map2.get("isRune"));
        rune.setTier((String)map2.get("tier"));
        rune.setType((String)map2.get("type"));
        return rune;
    }

    public Rune(int id, String name, String description, boolean isRune, String tier, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isRune = isRune;
        this.tier = tier;
        this.type = type;
    }

    public Rune() {
    }

    public boolean isRune() {
        return isRune;
    }

    public void setRune(boolean rune) {
        isRune = rune;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
