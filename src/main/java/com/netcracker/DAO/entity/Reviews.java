package com.netcracker.DAO.entity;

import javax.persistence.*;

/**
 * Created by 12345 on 17.01.2018.
 */
@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "id_reverv")
    private int id_reserv;
    @Column(name = "text")
    private String text;
    @Column(name = "rating")
    private double rating;

    public Reviews(int id, int id_reserv, String text, double rating) {
        this.id = id;
        this.id_reserv = id_reserv;
        this.text = text;
        this.rating = rating;
    }

    public Reviews(int id_reserv, String text, double rating) {
        this.id_reserv = id_reserv;
        this.text = text;
        this.rating = rating;
    }

    public Reviews() {
    }

    public Reviews(Reviews reviews) {
        this.id = reviews.id;
        this.id_reserv = reviews.id_reserv;
        this.text = reviews.text;
        this.rating = reviews.rating;
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

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", id_reserv=" + id_reserv +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                '}';
    }
}
