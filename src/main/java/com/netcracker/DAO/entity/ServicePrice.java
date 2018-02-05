package com.netcracker.DAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by user on 04.02.2018.
 */

@Entity

public class ServicePrice {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public ServicePrice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ServicePrice() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServicePrice{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
