package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.RoomDAO;
import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Room;
import com.netcracker.DAO.entity.RoomCast;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.MyParseException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 12345 on 18.01.2018.
 */
@Repository
public class RoomDAOImpl extends AbstractDAO implements RoomDAO {

    public RoomDAOImpl() {
    }

    @Override
    public int getRoomFree() throws MyParseException, FatalError {
        try {
            Integer cout;
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            Date date = new Date();
            java.sql.Date today_date = new java.sql.Date(format.parse(format.format(date)).getTime());
            Query query = getSession().createSQLQuery("SELECT count(*)as c\n" +
                    "FROM\n" +
                    "  (SELECT res.id_room,id_corp, count(*) as count  from rooms as room  join reserv  as res on room.id_room = res.id_room AND room.id_corps = res.id_corp\n" +
                    "  GROUP BY res.id_room, res.id_corp) as lol LEFT JOIN\n" +
                    "\n" +
                    "  (SELECT res.id_room,id_corp, count(*) as count from rooms as room left join reserv  as res on room.id_room = res.id_room AND room.id_corps = res.id_corp\n" +
                    "  where not (res.arrival_date < :date and :date1 < res.date_of_departure) or (res.id is null)GROUP BY res.id_room, res.id_corp)as lol1 ON lol.id_room=lol1.id_room AND lol.id_corp=lol1.id_corp\n" +
                    "WHERE lol.count != lol1.count or lol1.count is NULL ;\n");
            query.setParameter("date", today_date);
            query.setParameter("date1", today_date);
            List<BigInteger> list = query.list();

            cout = Integer.parseInt(list.get(0).toString());
            Query query1 = getSession().createQuery("SELECT count (*) from Room");
            List list1 = query1.list();
            Integer num = Integer.parseInt((String) list1.get(0).toString());
            if (num - cout >= 0) return num - cout;
            else return 0;
        }catch (ParseException ex){
            throw new MyParseException("not a valid date format");
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }

    }

        @Override
        public List<Room> getListRoom(String date) throws MyParseException, FatalError {
            List<Room> list = null;
            try {
                Query query = getSession().createQuery("SELECT new com.netcracker.DAO.entity.Room(res.id_room,res.id_corp,room.number_of_people, room.floor) from com.netcracker.DAO.entity.Room as room join room.reserv  as res where  NOT (res.arrival_date < :date and :date1 < res.date_of_departure )  and (res.arrival_date < :date2 and :date3 < res.date_of_departure )"); //and (room.id_corps = res.id_corp)"); //and  not(res.id is null)
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("yyyy-MM-dd");
                java.sql.Date desired_date = new java.sql.Date(format.parse(date).getTime());
                Date date2 = new Date();
                java.sql.Date today_date = new java.sql.Date(format.parse(format.format(date2)).getTime());
                query.setParameter("date", desired_date);
                query.setParameter("date1", desired_date);
                query.setParameter("date2", today_date);
                query.setParameter("date3", today_date);
                list = (List<Room> ) query.list();
                return list;
        }catch (ParseException ex){
                throw new MyParseException("not a valid date format");
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
    }
        }

    @Override
    public void saveRoom(RoomCast room) {
            persist(room);
    }

    @Override
    public List<Room> findAllRoom() throws FatalError {
        List<Room> list = null;
        try {
            Query query = getSession().createQuery("SELECT new Room(room.id_room,room.id_corps,room.number_of_people,room.floor) from Room as room ");
            list = (List<Room> ) query.list();
            return list;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public RoomCast findRoomById(int id_room, int id_corps) throws EntityNotFound, FatalError {
        try {
            Criteria criteria = getSession().createCriteria(RoomCast.class);
            criteria.add(Restrictions.eq("id_room", id_room));
            criteria.add(Restrictions.eq("id_corps", id_corps));
            RoomCast room = (RoomCast) criteria.uniqueResult();
            if(room == null) throw new EntityNotFound("NoRoom");
            return room;
        }catch (EntityNotFound ex){
            throw new EntityNotFound(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public int deleteRoomById(int id_room, int id_corp) throws FatalError {
        try {
            Query query = getSession().createQuery("DELETE  Room as room\n" +
                    " WHERE room.id_room = :id_room and room.id_corps = :id_corps ");
            query.setInteger("id_room", id_room);
            query.setInteger("id_corps", id_corp);
            int n = query.executeUpdate();
            return n;
        }catch (Exception ex){
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public List<Client> certainTime(String data, String data1) throws MyParseException, FatalError {
     try {
        Query query = getSession().createQuery("SELECT client from Client as client, Reserv as res where client.login = res.id_client and res.arrival_date > :date and res.date_of_departure < :date1 group by login");
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        java.sql.Date date01 = new java.sql.Date(format.parse(data).getTime());
        java.sql.Date date11 = new java.sql.Date(format.parse(data1).getTime());
        query.setParameter("date", date01);
        query.setParameter("date1", date11);

        List<Client> list = (List<Client>) query.list();
        return list;
    }catch (ParseException ex){
         throw new MyParseException("not a valid date format");
    }catch (Exception ex){
        throw new FatalError("base is not responding");
    }
    }
}

