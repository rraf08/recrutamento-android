package com.rpd.moviletest.model;

import java.io.Serializable;

/**
 * Created by Rafael Paz
 */
public class Episode implements Serializable{


    //Variables that are in json
    private int number;
    private String title;

    //Getters and setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
