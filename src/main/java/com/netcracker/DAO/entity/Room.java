package com.netcracker.DAO.entity;

/**
 * Created by 12345 on 17.01.2018.
 */
public class Room {
    private int id_room ;
    private int id_corps ;
    int number_of_people;
    int floor ;

    public Room(int id_room, int id_corps, int number_of_people, int floor) {
        this.id_room = id_room;
        this.id_corps = id_corps;
        this.number_of_people = number_of_people;
        this.floor = floor;
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
