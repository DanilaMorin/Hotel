package com.netcracker.DAO.entity;

import java.util.List;

/**
 * Created by user on 05.02.2018.
 */

public class DataClient {

    private List<Room> room;
    private int num;
    private List<ServicePrice> servicePrices;

    public DataClient(List<Room> room, int num, List<ServicePrice> servicePrices) {
        this.room = room;
        this.num = num;
        this.servicePrices = servicePrices;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<ServicePrice> getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(List<ServicePrice> servicePrices) {
        this.servicePrices = servicePrices;
    }

    @Override
    public String toString() {
        return "DataClient{" +
                "room=" + room +
                ", num=" + num +
                ", servicePrices=" + servicePrices +
                '}';
    }
}
