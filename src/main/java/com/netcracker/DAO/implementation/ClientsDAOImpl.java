package com.netcracker.DAO.implementation;


import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ClientsDAO;
import com.netcracker.DAO.entity.*;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
@Repository
public class ClientsDAOImpl extends AbstractDAO implements ClientsDAO {


    public ClientsDAOImpl() {
    }

    @Override
    public List<ClientReviews> getClientReviews() throws  FatalError {
        try {
            Query query = getSession().createQuery("SELECT new com.netcracker.DAO.entity.ClientReviews(c,rev) from com.netcracker.DAO.entity.Client as c, com.netcracker.DAO.entity.Reserv as res, com.netcracker.DAO.entity.Reviews as rev where c.login = res.id_client and rev.id_reserv = res.id");
            List<ClientReviews> list = query.list();
            return (List<ClientReviews>) list;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public boolean addClient(Client client)  {
            persist(client);
        return true;
    }

    @Override
    public List<Client> getClient() throws FatalError {
        try {
            List list;
            Criteria criteria = getSession().createCriteria(Client.class);
            list = criteria.list();
            return (List<Client>) list;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public Client getClientById(String login) throws EntityNotFound, FatalError {
        try {
            Criteria criteria = getSession().createCriteria(Client.class);
            criteria.add(Restrictions.eq("login", login));
            Client client = (Client) criteria.uniqueResult();
            if (client == null) throw  new EntityNotFound("NoClient");
            return client;

        }catch (EntityNotFound ex){
            ex.printStackTrace();
            throw new EntityNotFound(ex.getMessage());
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw  new FatalError("base is not responding");
        }
    }

    @Override
    public Double billForServices(String login) throws  EntityNotFound, FatalError {
        try {
            Double price;
            Query query = getSession().createQuery("SELECT  SUM (val_serv.price) FROM   com.netcracker.DAO.entity.Client as client, com.netcracker.DAO.entity.Reserv as res,com.netcracker.DAO.entity.AdditionalServices as additServ, com.netcracker.DAO.entity.ValueService as val_serv where res.id_client = client.login and res.id=additServ.id_reserv and additServ.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and client.login = :login");
            query.setParameter("login",login);
            price = (double) query.uniqueResult();

            return price;
        }catch (NullPointerException ex){
            ex.printStackTrace();
            throw new EntityNotFound("No price");
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }

    }

    @Override
    public List<Reviews> getRevByid(String login) throws FatalError {
        List list;
        try {
            Query query = getSession().createQuery("SELECT rev FROM  com.netcracker.DAO.entity.Reviews as rev,  com.netcracker.DAO.entity.Reserv as res WHERE res.id_client = :id_client and rev.id_reserv = res.id");
            query.setParameter("id_client", login);
             list = query.list();
            return (List<Reviews>)list;
        }catch (Exception ex){
            ex.printStackTrace();
           throw new FatalError("base is not responding");
        }

    }

    @Override
    public List<ServicePrice> typesOfServices(String login) throws FatalError {

        try {
            List list;
            Query query = getSession().createQuery("SELECT new com.netcracker.DAO.entity.ServicePrice (serv.name, val_serv.price)FROM com.netcracker.DAO.entity.Service as serv, com.netcracker.DAO.entity.Client as client,com.netcracker.DAO.entity.Reserv as res, com.netcracker.DAO.entity.AdditionalServices as add_serv, com.netcracker.DAO.entity.ValueService as val_serv where res.id_client = client.login and res.id = add_serv.id_reserv and add_serv.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and res.id_client = :id_client and serv.id = val_serv.id_service");
            query.setParameter("id_client", login);
            list =  query.list();
            return  (List<ServicePrice>) list;
        }catch (Exception ex){
            ex.printStackTrace();
            throw  new FatalError("base is not responding");
        }

    }

    @Override
    public List<Room> getRoomByClient(String login) throws FatalError {
        try {
            List<Room> list;
            Query query = getSession().createQuery("SELECT new Room(res.id_room,room.id_corps,room.number_of_people,room.floor) from Room as room join room.reserv  as res where  res.id_client = :login and res.id_corp = room.id_corps");
            query.setParameter("login", login);
            list = (List<Room>) query.list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public int getNumByClient(String login) throws FatalError, EntityNotFound {
        try {
            List list;
            Integer cout;
            Query query = getSession().createQuery("SELECT count (*) as n from Room as room join room.reserv  as res where  res.id_client = :login and res.id_corp = room.id_corps");
            query.setParameter("login", login);
            list = query.list();
            System.out.println(list.get(0));
            cout = Integer.parseInt((String) list.get(0).toString());
            return cout;
        }catch (NumberFormatException ex){
            ex.printStackTrace();
            throw new EntityNotFound("No login");

        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }

    }
}
