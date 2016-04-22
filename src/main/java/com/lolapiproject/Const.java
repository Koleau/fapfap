package com.lolapiproject;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Pflieger on 22/04/2016.
 */
public class Const {

    @Value("${api-key.lol}")
    public static String API_KEY;

}
