package com.netcracker.DAO.entity;



import com.netcracker.bakend.Validation;

import javax.persistence.*;

/**
 * Created by user on 15.01.2018.
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password", nullable = false )
    private String password;
    @Column(name ="surname", nullable = false)
    private String surname;
    @Column (name = "name", nullable = false)
    private String name;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "email")
    private String email;

//    @ManyToOne(optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="login")
//    private Reserv reservs;

    public Client() {
    }
    public Client(Client client){
        this.login = client.login;
        this.password = client.password;
        this.surname = client.surname;
        this.name = client.name;
        this.middle_name = client.middle_name;
        this.sex = client.sex;
        this.email = client.email;
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

    public void parseString(){
        this.login = Validation.parseStirng(login);
        this.password = Validation.parseStirng(password);
        this.surname = Validation.parseStirng(surname);
        this.name = Validation.parseStirng(name);
        this.middle_name = Validation.parseStirng(middle_name);
        this.sex = Validation.parseStirng(sex);
        this.email = Validation.parseStirng(email);
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
