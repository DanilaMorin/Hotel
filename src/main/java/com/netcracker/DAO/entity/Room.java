package com.netcracker.DAO.entity;

import javax.persistence.*;

/**
 * Created by 12345 on 17.01.2018.
 */
@Entity
@Table(name = "rooms")
public class Room {
    @Id()
    @GeneratedValue
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id_room", column = @Column(name = "id_room")),
            @AttributeOverride(name = "id_corps", column = @Column(name = "id_corps"))

    })

    private int id_room ;
    @Column(name = "id_corps")
    private int id_corps ;
    @Column(name = "number_of_people")
    private int number_of_people;
    @Column(name = "floor")
    private int floor ;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name = "id_room", insertable = false, updatable = false)

    private Reserv reserv;

    public Room(int id_corps, int number_of_people, int floor, Reserv reserv ) {
        this.id_corps = id_corps;
        this.number_of_people = number_of_people;
        this.floor = floor;
        this.reserv = reserv;
    }

    public Room(int id_rooms,int id_corps, int number_of_people, int floor ) {
        this.id_room = id_rooms;
        this.id_corps = id_corps;
        this.number_of_people = number_of_people;
        this.floor = floor;
        this.reserv = null;
    }
    public Room(int id_rooms,int id_corps, int number_of_people, int floor, Reserv reserv ) {
        this.id_room = id_rooms;
        this.id_corps = id_corps;
        this.number_of_people = number_of_people;
        this.floor = floor;
        this.reserv = reserv;
    }


    public Room() {
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_corps() {
        return id_corps;
    }

    public void setId_corps(int id_corps) {
        this.id_corps = id_corps;
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Reserv getReserv() {
        return reserv;
    }

    public void setReserv(Reserv reserv) {
        this.reserv = reserv;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id_room=" + id_room +
                ", id_corps=" + id_corps +
                ", number_of_people=" + number_of_people +
                ", floor=" + floor +
                '}';
    }
}
