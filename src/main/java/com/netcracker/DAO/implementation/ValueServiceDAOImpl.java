package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ValueServiceDAO;
import com.netcracker.DAO.entity.ValueService;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;
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
        try {
            persist(valueService);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ValueService> findAllValueService() {
        Criteria criteria = getSession().createCriteria(ValueService.class);
        return (List<ValueService>) criteria.list();
    }

    @Override
    public ValueService findValueServiceById(int id_corp, int id_service) {
        Criteria criteria = getSession().createCriteria(ValueService.class);
        criteria.add(Restrictions.eq("id_corp", id_corp));
        criteria.add(Restrictions.eq("id_service", id_service));
        return (ValueService) criteria.uniqueResult();
    }
    @Override
    public void deleteValueServiceById(int id_corp, int id_service) {

    }
}
