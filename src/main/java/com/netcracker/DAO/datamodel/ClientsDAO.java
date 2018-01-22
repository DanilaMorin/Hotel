package com.netcracker.DAO.datamodel;


import com.netcracker.DAO.entity.*;
import com.netcracker.DAO.entity.Reviews;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 15.01.2018.
 */
public interface ClientsDAO {
    boolean addClient(Client client) throws SQLException;
    List<Client> getClient() throws SQLException;
    Client getClientById();
    Map<Client, com.netcracker.DAO.entity.Reviews> getClientReviews() throws SQLException;
    Double billForServices(String login) throws SQLException;
    List<Reviews> getRevByid(String login) throws SQLException;
    Map<String, Double> typesOfServices(String login) throws SQLException;
}
