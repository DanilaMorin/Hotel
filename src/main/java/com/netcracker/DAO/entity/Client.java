package com.netcracker.DAO.entity;

import org.springframework.context.annotation.Bean;

/**
 * Created by user on 15.01.2018.
 */
public class Client {
    private String login;
    private String password;
    private String surname;
    private String name;
    private String middle_name;
    private String sex;
    private String email;

    public Client() {
    }

    public Client(String login, String password, String surname, String name, String middle_name, String sex, String email) {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
        this.sex = sex;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
