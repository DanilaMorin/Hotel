package com.netcracker.DAO.entity;

import javax.persistence.*;

/**
 * Created by 12345 on 30.01.2018.
 */
@Entity
@Table(name = "value_room")
public class ValueRoom {

    @Id
    @AttributeOverrides(value = {
            @AttributeOverride(name = "stars", column = @Column(name = "stars")),
            @AttributeOverride(name = "number_of_people", column = @Column(name = "number_of_people"))

    })

    private int stars;
    private int number_of_people;

    @Column(name = "price")
    private double price;

    @Column(name = "passive_costs")
    private double passive_costs;

    public ValueRoom() {
    }

    public ValueRoom(int stars, int number_of_people, double price, double passive_costs) {
        this.stars = stars;
        this.number_of_people = number_of_people;
        this.price = price;
        this.passive_costs = passive_costs;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPassive_costs() {
        return passive_costs;
    }

    public void setPassive_costs(double passive_costs) {
        this.passive_costs = passive_costs;
    }

    @Override
    public String toString() {
        return "ValueRoom{" +
                "stars=" + stars +
                ", number_of_people=" + number_of_people +
                ", price=" + price +
                ", passive_costs=" + passive_costs +
                '}';
    }
}
