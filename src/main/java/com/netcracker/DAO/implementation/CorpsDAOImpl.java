package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.CorpsDAO;
import com.netcracker.DAO.entity.Corps;
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
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class CorpsDAOImpl extends AbstractDAO implements CorpsDAO
{


    public CorpsDAOImpl() {
    }

    @Override
    public void saveCorps(Corps corps) {
            persist(corps);
    }

    @Override
    public List<Corps> findAllCorps() throws EntityNotFound {
        try{
        Criteria criteria = getSession().createCriteria(Corps.class);
        return (List<Corps>) criteria.list();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new EntityNotFound("base is not responding");
        }

    }

    @Override
    public Corps findCorpsById(int id) throws EntityNotFound, FatalError {
        try {
        Criteria criteria = getSession().createCriteria(Corps.class);
        criteria.add(Restrictions.eq("id", id));
        Corps corps = (Corps) criteria.uniqueResult();
        if (corps == null) throw  new EntityNotFound("NoCorps");
        return corps;
        }catch (EntityNotFound ex){
            throw new EntityNotFound(ex.getMessage());
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw  new FatalError("base is not responding");
        }
    }

    @Override
    public int deleteCorpsById(int id) throws FatalError {
        try {
        Query query =  getSession().createQuery("delete Corps where id = :id ");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }
}
