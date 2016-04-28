package com.lolapiproject.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * Created by Pflieger on 27/04/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Version {

    @Id
    private int id;

    private String collection;

    private String version;

    public Version() {
    }

    public Version(int id, String collection, String version) {
        this.id = id;
        this.collection = collection;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
