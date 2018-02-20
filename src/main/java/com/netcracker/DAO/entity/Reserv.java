package com.netcracker.DAO.entity;

import com.netcracker.bakend.Validation;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by 12345 on 29.01.2018.
 */
@Entity
@Table(name="reserv")
public class Reserv  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "arrival_date")
    private Date arrival_date;
    @Column(name = "date_of_departure")
    private Date date_of_departure;
    @Column(name = "id_room")
    private int id_room;
    @Column(name = "id_corp")
    private int id_corp;
    @Column(name = "id_org")
    private String id_org;
    @Column (name = "id_client")
    private String id_client;


    @OneToMany (mappedBy="reserv", fetch=FetchType.EAGER)
    private Collection<Room> tenants;



    public Reserv() {
    }

    public Reserv(Date arrival_date, Date date_of_departure, int id_room, int id_corp, String id_org, String id_client, Collection<Room> tenants) {
        this.arrival_date = arrival_date;
        this.date_of_departure = date_of_departure;
        this.id_room = id_room;
        this.id_corp = id_corp;
        this.id_org = id_org;
        this.id_client = id_client;
        this.tenants = tenants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getDate_of_departure() {
        return date_of_departure;
    }

    public void setDate_of_departure(Date date_of_departure) {
        this.date_of_departure = date_of_departure;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_corp() {
        return id_corp;
    }

    public void setId_corp(int id_corp) {
        this.id_corp = id_corp;
    }

    public String getId_org() {
        return id_org;
    }

    public void setId_org(String id_org) {
        this.id_org = id_org;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public void parseString(){
        this.id_org = Validation.parseStirng(id_org);
        this.id_client = Validation.parseStirng(id_client);
    }
    @Override
    public String toString() {
        return "Reserv{" +
                "id=" + id +
                ", arrival_date=" + arrival_date +
                ", date_of_departure=" + date_of_departure +
                ", id_room=" + id_room +
                ", id_corp=" + id_corp +
                ", id_org='" + id_org + '\'' +
                ", id_client='" + id_client + '\'' +
                '}';
    }


    public Collection<Room> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Room> tenants) {
        this.tenants = tenants;
    }
}
