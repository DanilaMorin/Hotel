package com.netcracker.DAO.implementation;


import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ClientsDAO;
import com.netcracker.DAO.entity.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
@Repository
public class ClientsDAOImpl extends AbstractDAO implements ClientsDAO {


    public ClientsDAOImpl() {
    }

    @Override
    public List<ClientReviews> getClientReviews()  {
        List list;
        //Query query = getSession().createQuery(" SELECT  o FROM com.netcracker.DAO.entity.Client as c join  com.netcracker.DAO.entity.Reserv as res   on com.netcracker.DAO.entity.Client.login = com.netcracker.DAO.entity.Reserv.id_client join com.netcracker.DAO.entity.Reviews as rev on  rev.id_reserv = res.id ");
        Query query = getSession().createQuery("SELECT new com.netcracker.DAO.entity.ClientReviews(c,rev) from com.netcracker.DAO.entity.Client as c, com.netcracker.DAO.entity.Reserv as res, com.netcracker.DAO.entity.Reviews as rev where c.login = res.id_client and rev.id_reserv = res.id");
        list =  query.list();
        System.out.println(list);
        return (List<ClientReviews> )list;
    }

    @Override
    public boolean addClient(Client client)  {
        boolean b = true;
        persist(client);
        return b;
    }

    @Override
    public List<Client> getClient()  {
        List<Client> list = new ArrayList<Client>();
       Criteria criteria = getSession().createCriteria(Client.class);
        return (List<Client>) list;
    }

    @Override
    public Client getClientById(String login) {
        Criteria criteria = getSession().createCriteria(Client.class);
        criteria.add(Restrictions.eq("login", login));
        return (Client) criteria.uniqueResult();
    }

    @Override
    public Double billForServices(String login)  {
        Double price = 0.0;

        Query query = getSession().createQuery("SELECT  SUM (val_serv.price) FROM   com.netcracker.DAO.entity.Client as client, com.netcracker.DAO.entity.Reserv as res,com.netcracker.DAO.entity.AdditionalServices as additServ, com.netcracker.DAO.entity.ValueService as val_serv where res.id_client = client.login and res.id=additServ.id_reserv and additServ.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and client.login = :login");
        query.setParameter("login",login);
        try {
            price = (double) query.uniqueResult();
        }catch (Exception ex){
            System.out.println("Нет такого логина");
        };
        System.out.println(price);
        return price;
    }

    @Override
    public List<Reviews> getRevByid(String login)  {
//        preparedStatement = connection.prepareStatement("SELECT  rev.id, id_reverv, text, rating\n" +
//                "  FROM public.reviews as rev,  public.reserv as res " +
//                "  where res.id_client = ? and rev.id_reverv = res.id;");
        Query query = getSession().createQuery("SELECT rev FROM  com.netcracker.DAO.entity.Reviews as rev,  com.netcracker.DAO.entity.Reserv as res WHERE res.id_client = :id_client and rev.id_reserv = res.id");
        query.setParameter("id_client",login);
       List list = query.list();
        System.out.println(list);
        return list;
    }

    @Override
    public List<ServicePrice> typesOfServices(String login)  {


//        preparedStatement = connection.prepareStatement("SELECT service.name , price\n" +
//                "  FROM public.service, public.clients, public.reserv as res, public.additional_services as add_serv,  public.value_service as val_serv\n" +
//                "  WHERE res.id_client = clients.login and res.id = add_serv.id_reserv and add_serv.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and res.id_client = ? and service.id = val_serv.id_service" +
//                "  ;");
        Query query = getSession().createQuery("SELECT new com.netcracker.DAO.entity.ServicePrice (serv.name, val_serv.price)FROM com.netcracker.DAO.entity.Service as serv, com.netcracker.DAO.entity.Client as client,com.netcracker.DAO.entity.Reserv as res, com.netcracker.DAO.entity.AdditionalServices as add_serv, com.netcracker.DAO.entity.ValueService as val_serv where res.id_client = client.login and res.id = add_serv.id_reserv and add_serv.id_service = val_serv.id_service and val_serv.id_corp = res.id_corp and res.id_client = :id_client and serv.id = val_serv.id_service");
        query.setParameter("id_client",login);
        List<ServicePrice> list = (List<ServicePrice>) query.list();
        System.out.println(list);
        return  list;
    }

    @Override
    public List<Room> getRoomByClient(String login) {
        Query query = getSession().createQuery("SELECT new Room(res.id_room,room.id_corps,room.number_of_people,room.floor) from Room as room join room.reserv  as res where  res.id_client = :login");
        query.setParameter("login", login);
        List<Room> list = (List<Room>) query.list();
        return list;
    }

    @Override
    public int getNumByClient(String login) {
        Query query = getSession().createQuery("SELECT count (*) as n from Room as room join room.reserv  as res where  res.id_client = :login");
        query.setParameter("login", login);
         List list = query.list();
       Integer cout = null;
        cout = Integer.parseInt((String) list.get(0).toString());
        return cout;
    }
}
