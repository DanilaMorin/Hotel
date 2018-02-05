package com.netcracker.services;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.ClientReviews;
import com.netcracker.DAO.entity.Reviews;
import com.netcracker.DAO.entity.ServicePrice;

import java.util.List;

/**
 * Created by user on 02.02.2018.
 */
public interface ClientService {
    boolean addClient(Client client);
    List<Client> getClient() ;
    Client getClientById(String login);
    List<ClientReviews> getClientReviews() ;
    Double billForServices(String login) ;
    List<Reviews> getRevByid(String login) ;
    List<ServicePrice> typesOfServices(String login);
}
