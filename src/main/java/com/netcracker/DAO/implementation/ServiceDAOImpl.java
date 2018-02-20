package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ServiceDAO;
import com.netcracker.DAO.entity.Service;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
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
            persist(service);
    }

    @Override
    public List<Service> findAllService() throws FatalError {
        try {
            Criteria criteria = getSession().createCriteria(Service.class);
            return (List<Service>) criteria.list();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }


    @Override
    public Service findServiceById(int id) throws EntityNotFound, FatalError {
       try {
           Criteria criteria = getSession().createCriteria(Service.class);
           criteria.add(Restrictions.eq("id", id));
           Service service = (Service) criteria.uniqueResult();
           if (service == null) throw new EntityNotFound("NoService");
           return service;
       }catch (EntityNotFound ex){
           throw new EntityNotFound(ex.getMessage());
       }catch (Exception ex){
           throw new FatalError("base is not responding");
       }
    }

    @Override
    public Integer deleteServiceById(int id) throws FatalError {
            try {
                Query query = getSession().createQuery("DELETE  Service as service\n" +
                        " WHERE service.id = :id");
                query.setInteger("id", id);
                int n = query.executeUpdate();
                return n;
            }catch (Exception ex){
                throw new FatalError("base is not responding");
            }
    }
}
