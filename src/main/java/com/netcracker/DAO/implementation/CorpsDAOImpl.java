package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.CorpsDAO;
import com.netcracker.DAO.entity.Corps;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class CorpsDAOImpl extends AbstractDAO implements CorpsDAO
{


    public CorpsDAOImpl() {
    }

    @Override
    public void saveCorps(Corps corps) {
        try {
            persist(corps);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Corps> findAllCorps() {
        Criteria criteria = getSession().createCriteria(Corps.class);
        return (List<Corps>) criteria.list();
    }

    @Override
    public Corps findCorpsById(int id) {
        Criteria criteria = getSession().createCriteria(Corps.class);
        criteria.add(Restrictions.eq("id", id));
        return (Corps) criteria.uniqueResult();
    }

    @Override
    public int deleteCorpsById(int id) {
        Query query =  getSession().createQuery("delete Corps where id = :id ");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result;
    }
}
