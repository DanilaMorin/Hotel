package com.netcracker.DAO.entity;

/**
 * Created by 12345 on 17.01.2018.
 */
public class Reviews {
    private int id;
    private int id_reserv;
    private String text;
    private double rating;

    public Reviews(int id, int id_reserv, String text, double rating) {
        this.id = id;
        this.id_reserv = id_reserv;
        this.text = text;
        this.rating = rating;
    }

    public Reviews() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_reserv() {
        return id_reserv;
    }

    public void setId_reserv(int id_reserv) {
        this.id_reserv = id_reserv;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
