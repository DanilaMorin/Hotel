package com.netcracker.DAO.implementation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 15.01.2018.
 */
//@Configuration
//@Configuration
public class JDBCConfig {


//    @Bean
//    public Connection getConnect(){
//        Connection connection = null;
//        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
//        String nameb = "postgres";
//        String password1 = "postgres";
//        try
//
//        {
//            Class.forName("org.postgresql.Driver");
//            System.out.println("connect");
//            connection = DriverManager.getConnection(url, nameb, password1);
//            System.out.println("Соединение установлено");
//        } catch (Exception ex)
//
//        {
//            System.out.println("error");
//        } finally
//
//        {
//
//            }
//
//        return connection;
//    }


    static Connection  getConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String nameb = "postgres";
        String password1 = "postgres";
        try

        {
            Class.forName("org.postgresql.Driver");
            System.out.println("connect");
            connection = DriverManager.getConnection(url, nameb, password1);
            System.out.println("Соединение установлено");
        } catch (Exception ex)

        {
            System.out.println("error");
        } finally

        {

            }

        return connection;
    }
}