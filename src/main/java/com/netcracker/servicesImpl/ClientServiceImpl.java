package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.ClientsDAO;
import com.netcracker.DAO.entity.*;
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
        boolean b =false;
        try {
            b = clientsDAO.addClient(client);
        }catch (Exception ex){
            b = false;
            Logger.getLogger(ClientReviews.class.getName()).log(Level.SEVERE, null, ex);

        }
        return b;
    }

    @Override
    public List<Client> getClient() {
        return clientsDAO.getClient();
    }

    @Override
    public Client getClientById(String login) {
        return clientsDAO.getClientById(login);
    }

    @Override
    public List<ClientReviews> getClientReviews() {
        List<ClientReviews> list;
        try {
            list = clientsDAO.getClientReviews();

        }catch (Exception ex){
            list = null;
            Logger.getLogger(ClientReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Double billForServices(String login) {

        return clientsDAO.billForServices(login);
    }

    @Override
    public List<Reviews> getRevByid(String login) {

        return clientsDAO.getRevByid(login);
    }

    @Override
    public List<ServicePrice> typesOfServices(String login) {
        return clientsDAO.typesOfServices(login);
    }

    @Override
    public DataClient getDataClient(String login) {
        List<Room> rooms = clientsDAO.getRoomByClient(login);
        Integer n = clientsDAO.getNumByClient(login);
        List<ServicePrice> servicePrices = clientsDAO.typesOfServices(login);
        System.out.println(rooms);
        System.out.println(n);
        System.out.println(servicePrices);
        DataClient dataClient = new DataClient(rooms,n,servicePrices);

        return dataClient;
    }
}
