package com.netcracker.services;

import com.netcracker.DAO.entity.*;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.TraceException;

import java.util.List;

/**
 * Created by user on 02.02.2018.
 */
public interface ClientService {
    boolean addClient(Client client);
    List<Client> getClient() throws FatalError;
    Client getClientById(String login) throws FatalError, EntityNotFound;
    List<ClientReviews> getClientReviews() throws FatalError;
    Double billForServices(String login)  throws  EntityNotFound, FatalError;
    List<Reviews> getRevByid(String login) throws FatalError;
    List<ServicePrice> typesOfServices(String login) throws FatalError;
    DataClient getDataClient(String login) throws FatalError, EntityNotFound;
    boolean deleteClientById(String login) throws FatalError;
}
