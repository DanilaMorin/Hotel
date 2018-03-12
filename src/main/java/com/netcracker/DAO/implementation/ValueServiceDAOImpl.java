package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ValueServiceDAO;
import com.netcracker.DAO.entity.ValueService;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 31.01.2018.
 */
@Repository
public class ValueServiceDAOImpl extends AbstractDAO implements ValueServiceDAO {
    public ValueServiceDAOImpl() {
    }

    @Override
    public void saveValueService(ValueService valueService) {
            persist(valueService);
    }

    @Override
    public List<ValueService> findAllValueService() throws FatalError {
        try {
            Criteria criteria = getSession().createCriteria(ValueService.class);
            return (List<ValueService>) criteria.list();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public ValueService findValueServiceById(int id_corp, int id_service) throws EntityNotFound, FatalError {
        try {
            Criteria criteria = getSession().createCriteria(ValueService.class);
            criteria.add(Restrictions.eq("id_corp", id_corp));
            criteria.add(Restrictions.eq("id_service", id_service));
            ValueService valueService = (ValueService) criteria.uniqueResult();
            if(valueService == null) throw new EntityNotFound("NoValueService");
            return valueService;
        }catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            throw new EntityNotFound(entityNotFound.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }
    @Override
    public boolean deleteValueServiceById(int id_corp, int id_service) throws FatalError {
        try {
            Query query = getSession().createQuery("DELETE  ValueService as valueserv\n" +
                    " WHERE valueserv.id_corp = :id_corp and valueserv.id_service = :id_service ");
            query.setInteger("id_corp", id_corp);
            query.setInteger("id_service", id_service);
            int n = query.executeUpdate();
            if (n > 0) return true;
            else return false;
        }catch (Exception ex){
            throw new FatalError("base is not responding");
        }
    }
}
