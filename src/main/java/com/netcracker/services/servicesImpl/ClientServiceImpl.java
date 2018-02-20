package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.ClientsDAO;
import com.netcracker.DAO.entity.*;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.TraceException;
import com.netcracker.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 02.02.2018.
 */
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    public ClientServiceImpl() {
    }

    @Autowired
    ClientsDAO clientsDAO;
    @Override
    public boolean addClient(Client client) {
        boolean b = clientsDAO.addClient(client);
        return b;
    }

    @Override
    public List<Client> getClient() throws FatalError {
        return clientsDAO.getClient();
    }

    @Override
    public Client getClientById(String login) throws FatalError, EntityNotFound {
        return clientsDAO.getClientById(login);
    }

    @Override
    public List<ClientReviews> getClientReviews() throws  FatalError {
        List<ClientReviews> list;
            list = clientsDAO.getClientReviews();
        return list;
    }

    @Override
    public Double billForServices(String login) throws FatalError, EntityNotFound {

        return clientsDAO.billForServices(login);
    }

    @Override
    public List<Reviews> getRevByid(String login) throws FatalError {

        return clientsDAO.getRevByid(login);
    }

    @Override
    public List<ServicePrice> typesOfServices(String login) throws FatalError {
        return clientsDAO.typesOfServices(login);
    }

    @Override
    public DataClient getDataClient(String login) throws FatalError, EntityNotFound {
        DataClient dataClient;
        List<Room> rooms = clientsDAO.getRoomByClient(login);
        Integer n = clientsDAO.getNumByClient(login);
        List<ServicePrice> servicePrices = clientsDAO.typesOfServices(login);
        dataClient = new DataClient(rooms, n, servicePrices);
        return dataClient;

    }
}