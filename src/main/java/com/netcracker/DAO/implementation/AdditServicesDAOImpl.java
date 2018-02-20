package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.AdditServicesDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SharedSessionContract;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

import java.io.Closeable;
import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class AdditServicesDAOImpl extends AbstractDAO implements AdditServicesDAO {

    public AdditServicesDAOImpl() {
    }



    @Override
    public Boolean saveAdditServices(AdditionalServices corps) {
        Boolean b = false;
        try {
            persist(corps);
            b = true;
        return b;
        }
              catch (Exception ex){
                  System.out.println("ex = " + ex);
              return false;
        }

    }

    @Override
    public List<AdditionalServices> findAllAdditServices() throws EntityNotFound {
        try {
            Criteria criteria = getSession().createCriteria(AdditionalServices.class);
            return (List<AdditionalServices>) criteria.list();
        }catch (Exception ex){
        ex.printStackTrace();
        throw new EntityNotFound("base is not responding");
    }

    }

    @Override
    public AdditionalServices findAdditServicesById(int id) throws EntityNotFound {
        try {
            Criteria criteria = getSession().createCriteria(AdditionalServices.class);
            criteria.add(Restrictions.eq("id", id));
            AdditionalServices additionalServices = (AdditionalServices) criteria.uniqueResult();
            if (additionalServices == null) throw  new EntityNotFound("NoEntity");
            return additionalServices;
        }catch (Exception ex){
            throw  new EntityNotFound("Неизвестная ошибка");
        }

    }

    @Override
    public int   deleteAdditServicesById(int id_reserv, int id_service) throws FatalError {
        try {
            Query query = getSession().createQuery("delete AdditionalServices where id_reserv = :id_reserv and id_service = :id_service");
            query.setParameter("id_reserv", id_reserv);
            query.setParameter("id_service", id_service);
            int result = query.executeUpdate();
            return result;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw  new FatalError("base is not responding");
        }

    }
}
