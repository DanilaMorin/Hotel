package com.netcracker.DAO.datamodel;


import com.netcracker.DAO.entity.*;
import com.netcracker.DAO.entity.Reviews;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface ClientsDAO {
    boolean addClient(Client client);
    List<Client> getClient() ;
    Client getClientById(String login);
    List<ClientReviews> getClientReviews() ;
    Double billForServices(String login) ;
    List<Reviews> getRevByid(String login) ;
    List<ServicePrice> typesOfServices(String login);
    List<Room> getRoomByClient(String login);
    int getNumByClient(String login);
}
