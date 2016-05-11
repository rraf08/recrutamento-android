package com.rpd.moviletest.model;

import java.util.Map;

/**
 * Created by Rafael Paz
 */
public class Images {

    //Variables that are in json
    private Map<String,String> fanart;
    private Map<String,String> poster;

    //Getters and setters
    public Map<String,String> getFanart(){
        return fanart;
    }

    public Map<String,String> getPoster(){
        return poster;
    }
}
