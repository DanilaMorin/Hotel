package com.netcracker.DAO.implementation;


import com.netcracker.DAO.datamodel.ClientsDAO;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 15.01.2018.
 */
@Repository
public class ClientsDAOImpl implements ClientsDAO {
//    @Autowired
//    private Connection connection;

    public ClientsDAOImpl() {
    }

    @Override
    public Map<Client, Reviews> getClientReviews() throws SQLException {
        Map<Client, Reviews> map = new HashMap<>();

        Connection connection = JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT login, password, surname, name, middle_name, sex, email, rev.id, id_reverv, text, rating\n" +
                "  FROM public.reviews as rev,  public.clients, public.reserv as res " +
                "  where res.id_client = clients.login and rev.id_reverv = res.id;");
        ResultSet result = preparedStatement.executeQuery();

        System.out.println("Выводим PreparedStatement");
        while (result.next()) {
            String login = result.getString("login");
            String password = result.getString("password");
            String surname = result.getString("surname");
            String name = result.getString("name");
            String middle_name = result.getString("middle_name");
            String sex = result.getString("sex");
            String email = result.getString("email");

            int id = result.getInt("id");
            int id_reserv = result.getInt("id_reverv");
            String text = result.getString("text");
            double rating = result.getDouble("rating");
            Client client = new Client(login, password, surname, name, middle_name, sex, email);
            Reviews reviews = new Reviews(id, id_reserv, text, rating);
            map.put(client, reviews);


        }

            if (connection != null) {
             connection.close();
             System.out.println("Cоединение закрыто");
           }
        return map;
    }

    @Override
    public boolean addClient(Client client) throws SQLException {
        boolean b = false;


        Connection connection = JDBCConfig.getConnection();
            connection.createStatement();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO public.clients(\n" +
                            "            login, password, surname, name, middle_name, sex, email)\n" +
                            "    VALUES (?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, client.getLogin());
            preparedStatement.setString(2, client.getPassword());
            preparedStatement.setString(3, client.getMiddle_name());
            preparedStatement.setString(4, client.getName());
            preparedStatement.setString(5, client.getMiddle_name());
            preparedStatement.setString(6,  client.getSex());
            preparedStatement.setString(7, client.getEmail());
            b = preparedStatement.execute();

        return b;
    }

    @Override
    public List<Client> getClient() throws SQLException {
        List<Client> list = new ArrayList<Client>();
        Connection connection =JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT login, password, surname, name, middle_name, sex, email\n" +
                "  FROM public.clients;");

        ResultSet result2 = preparedStatement.executeQuery();

        System.out.println("Выводим PreparedStatement");
        while (result2.next()) {
            String login = result2.getString("login");
            String password = result2.getString("password");
            String surname = result2.getString("surname");
            String name = result2.getString("name");
            String middle_name = result2.getString("middle_name");
            String sex = result2.getString("sex");
            String email = result2.getString("email");
//            System.out.println("Номер в выборке #" + result2.getRow()
//                    + "\t" + result2.getString("name") +"\t" + result2.getInt("stars")+"\t" + result2.getInt("num_loc")+"\t"+result2.getDouble("price"));


            list.add(new Client(login,password,surname,name,middle_name,sex,email));
        }

        if (connection != null) {
            connection.close();
            System.out.println("Cоединение закрыто");
        }

        return list;
    }

    @Override
    public Client getClientById() {
        return null;
    }

    @Override
    public Double billForServices(String login) throws SQLException {
        Double price = 0.0;

        Connection connection = JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT SUM(price) as price\n" +
                "  FROM  public.clients, public.reserv as res, public.additional_services as add_serv,  public.value_service as val_serv\n" +
                "  WHERE res.id_client = clients.login and res.id = add_serv.id_reserv and add_serv.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and res.id_client = ?\n" +
                "  ;");
        preparedStatement.setString(1, login);
        ResultSet result = preparedStatement.executeQuery();

        System.out.println("Выводим PreparedStatement");
        while (result.next()) {
            price = result.getDouble("price");

        }

        if (connection != null) {
            connection.close();
            System.out.println("Cоединение закрыто");
        }

        return price;
    }

    @Override
    public List<Reviews> getRevByid(String login) throws SQLException {
        List<Reviews> list = new ArrayList<>();

        Connection connection = JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT  rev.id, id_reverv, text, rating\n" +
                "  FROM public.reviews as rev,  public.reserv as res " +
                "  where res.id_client = ? and rev.id_reverv = res.id;");
        preparedStatement.setString(1,login);
        ResultSet result = preparedStatement.executeQuery();

        System.out.println("Выводим PreparedStatement");
        while (result.next()) {
            int id = result.getInt("id");
            int id_reserv = result.getInt("id_reverv");
            String text = result.getString("text");
            double rating = result.getDouble("rating");
            Reviews reviews = new Reviews(id, id_reserv, text, rating);
            list.add(reviews);
        }

        if (connection != null) {
            connection.close();
            System.out.println("Cоединение закрыто");
        }
        return list;
    }

    @Override
    public Map<String, Double> typesOfServices(String login) throws SQLException {
        Map<String,Double> map = new HashMap<>();
        Connection connection = JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT service.name , price\n" +
                "  FROM public.service, public.clients, public.reserv as res, public.additional_services as add_serv,  public.value_service as val_serv\n" +
                "  WHERE res.id_client = clients.login and res.id = add_serv.id_reserv and add_serv.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and res.id_client = ? and service.id = val_serv.id_service" +
                "  ;");
        preparedStatement.setString(1, login);
        ResultSet result = preparedStatement.executeQuery();

        System.out.println("Выводим PreparedStatement");
        while (result.next()) {
            map.put(result.getString("name"),result.getDouble("price"));


        }


        if (connection != null) {
            connection.close();
            System.out.println("Cоединение закрыто");
        }
        return map;
    }
}
