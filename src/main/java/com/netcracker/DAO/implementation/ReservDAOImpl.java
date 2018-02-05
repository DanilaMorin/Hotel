package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ReservDAO;
import com.netcracker.DAO.entity.Reserv;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
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
    public List<Reserv> findAllReserv() {
        Criteria criteria = getSession().createCriteria(Reserv.class);
        return (List<Reserv>) criteria.list();
    }

    @Override
    public Reserv findReservById(int id) {
        Criteria criteria = getSession().createCriteria(Reserv.class);
        criteria.add(Restrictions.eq("id", id));
        return (Reserv) criteria.uniqueResult();
    }

    @Override
    public int  deleteReservById(int id) {
        Query query = getSession().createQuery("DELETE  Reserv as res\n" +
                " WHERE res.id = :id ");
        query.setInteger("id", id);
        int n = query.executeUpdate();
        return n;

    }
}
