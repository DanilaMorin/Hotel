package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ReservDAO;
import com.netcracker.DAO.entity.Reserv;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 29.01.2018.
 */
@Repository()
public class ReservDAOImpl extends AbstractDAO implements ReservDAO {


    public ReservDAOImpl() {

    }


    @Override
    public void saveReserv(Reserv reserv) {
            persist(reserv);
    }

    @Override
    public List<Reserv> findAllReserv() throws FatalError {
        try {
            Criteria criteria = getSession().createCriteria(Reserv.class);
            List<Reserv> list = (List<Reserv>) criteria.list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public Reserv findReservById(int id) throws EntityNotFound, FatalError {
        try {
        Criteria criteria = getSession().createCriteria(Reserv.class);
        criteria.add(Restrictions.eq("id", id));
        Reserv reserv = (Reserv) criteria.uniqueResult();
        if (reserv == null) throw new EntityNotFound("NoReserv");
        return reserv;
        }
    catch (EntityNotFound ex){
        throw new EntityNotFound(ex.getMessage());
    }
        catch (Exception ex){
        ex.printStackTrace();
        throw  new FatalError("base is not responding");
    }
    }

    @Override
    public int  deleteReservById(int id) throws FatalError {
        try {
        Query query = getSession().createQuery("DELETE  Reserv as res\n" +
                " WHERE res.id = :id ");
        query.setInteger("id", id);
        int n = query.executeUpdate();
        return n;
    }
        catch (Exception ex){
        ex.printStackTrace();
        throw new FatalError("base is not responding");
    }

    }
}
