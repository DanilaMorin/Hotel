package com.netcracker.DAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 12345 on 30.01.2018.
 */
@Entity
@Table(name = "value_service")
public class ValueService {

    @Id
    @Column(name = "id_corp")
    private int id_corp;


    @Column(name = "id_service")
    private int id_service;

    @Column(name = "price")
    private double price;

    public ValueService() {
    }

    public ValueService(int id_corp, int id_service, double price) {
        this.id_corp = id_corp;
        this.id_service = id_service;
        this.price = price;
    }

    public int getId_corp() {
        return id_corp;
    }

    public void setId_corp(int id_corp) {
        this.id_corp = id_corp;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ValueService{" +
                "id_corp=" + id_corp +
                ", id_service=" + id_service +
                ", price=" + price +
                '}';
    }
}
