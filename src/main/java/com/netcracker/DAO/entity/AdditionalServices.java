package com.netcracker.DAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 12345 on 30.01.2018.
 */

@Entity
@Table(name = "additional_services")
public class AdditionalServices {

    @Id
    private int id_reserv;
    @Column(name = "id_service")
    private int id_service;

    public AdditionalServices() {
    }

    public AdditionalServices(int id_reserv, int id_service) {
        this.id_reserv = id_reserv;
        this.id_service = id_service;
    }

    public int getId_reserv() {
        return id_reserv;
    }

    public void setId_reserv(int id_reserv) {
        this.id_reserv = id_reserv;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    @Override
    public String toString() {
        return "AdditionalServices{" +
                "id_reserv=" + id_reserv +
                ", id_service=" + id_service +
                '}';
    }
}
