package com.netcracker.DAO.entity;

import javax.persistence.*;

/**
 * Created by 12345 on 30.01.2018.
 */

@Entity
@Table(name = "corps")
public class Corps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "stars")
    private int stars;

    @Column(name = "floors")
    private int floors;

    @Column(name = "rooms")
    private int rooms;

    @Column(name = "rooms_on_floor")
    private int rooms_on_floor;

    @Column(name = "name")
    private String name;

    public Corps() {
    }

    public Corps(int stars, int floors, int rooms, int rooms_on_floor, String name) {
        this.stars = stars;
        this.floors = floors;
        this.rooms = rooms;
        this.rooms_on_floor = rooms_on_floor;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRooms_on_floor() {
        return rooms_on_floor;
    }

    public void setRooms_on_floor(int rooms_on_floor) {
        this.rooms_on_floor = rooms_on_floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CorpsDAO{" +
                "id=" + id +
                ", stars=" + stars +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", rooms_on_floor=" + rooms_on_floor +
                ", name='" + name + '\'' +
                '}';
    }
}
