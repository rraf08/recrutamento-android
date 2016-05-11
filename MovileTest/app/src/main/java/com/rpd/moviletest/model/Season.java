package com.rpd.moviletest.model;

/**
 * Created by Rafael Paz
 */
public class Season {

    //Variables that are in json
    private int number;
    private Double rating;
    private Images images;

    //Getters and setters
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getRating() {
        rating=Math.floor(rating*10) / 10;
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


}
