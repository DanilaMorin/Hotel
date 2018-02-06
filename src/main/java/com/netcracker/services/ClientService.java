package com.netcracker.services;

import com.netcracker.DAO.entity.*;

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
    DataClient getDataClient(String login);
}
