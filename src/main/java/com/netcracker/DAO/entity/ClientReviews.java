package com.netcracker.DAO.entity;


/**
 * Created by user on 04.02.2018.
 */


public class ClientReviews {
    private Client client;
    private Reviews reviews;

    public ClientReviews(String login, String password, String surname, String name, String middle_name, String sex, String email, int id, int id_reserv, String text, double rating) {
        this.client = new Client(login,password,surname,name,middle_name,sex,email);
        this.reviews = new Reviews(id, id_reserv,text, rating);
    }

    public ClientReviews(Client client, Reviews reviews) {
        this.client = client;
        this.reviews = reviews;
    }

    public ClientReviews() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

}
