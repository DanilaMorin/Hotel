package com.netcracker.DAO.entity;

import javax.persistence.*;

/**
 * Created by 12345 on 30.01.2018.
 */

@Entity
@Table(name = "additional_services")
public class AdditionalServices {

    @Id
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id_reserv", column = @Column(name = "id_reserv")),
            @AttributeOverride(name = "id_service", column = @Column(name = "id_service"))

    })


    private int id_reserv;
    private int id_service;

    public AdditionalServices() {
    }

    public AdditionalServices(int id_reserv, int id_service) {
        this.id_reserv = id_reserv;
        this.id_service = id_service;
    }

    public AdditionalServices(AdditionalServices additionalServices) {
        this.id_reserv = additionalServices.id_reserv;
        this.id_service = additionalServices.id_service;
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
