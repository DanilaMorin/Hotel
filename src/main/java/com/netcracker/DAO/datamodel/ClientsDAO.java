package com.netcracker.DAO.datamodel;


import com.netcracker.DAO.entity.*;
import com.netcracker.DAO.entity.Reviews;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.TraceException;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface ClientsDAO {
    boolean addClient(Client client);
    List<Client> getClient() throws FatalError;
    Client getClientById(String login) throws EntityNotFound, FatalError;
    List<ClientReviews> getClientReviews() throws EntityNotFound;
    Double billForServices(String login)  throws  EntityNotFound, FatalError;
    List<Reviews> getRevByid(String login) throws FatalError;
    List<ServicePrice> typesOfServices(String login) throws FatalError;
    List<Room> getRoomByClient(String login) throws FatalError;
    int getNumByClient(String login) throws FatalError, EntityNotFound;
}
