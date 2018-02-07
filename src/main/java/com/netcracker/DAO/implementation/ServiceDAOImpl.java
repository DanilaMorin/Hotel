package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ServiceDAO;
import com.netcracker.DAO.entity.Service;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class ServiceDAOImpl extends AbstractDAO implements ServiceDAO{

    public ServiceDAOImpl() {
    }

    @Override
    public void saveService(Service service) {
        try {
            persist(service);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> findAllService() {
        Criteria criteria = getSession().createCriteria(Service.class);
        return (List<Service>) criteria.list();
    }

    @Override
    public Service findServiceById(int id) {
        Criteria criteria = getSession().createCriteria(Service.class);
        criteria.add(Restrictions.eq("id", id));
        return (Service) criteria.uniqueResult();
    }

    @Override
    public void deleteServiceById(int id) {

    }
}
