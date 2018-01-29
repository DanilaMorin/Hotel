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
    boolean addClient(Client client);
    List<Client> getClient() ;
    Client getClientById();
    Map<Client, com.netcracker.DAO.entity.Reviews> getClientReviews() ;
    Double billForServices(String login) ;
    List<Reviews> getRevByid(String login) ;
    Map<String, Double> typesOfServices(String login);
}
