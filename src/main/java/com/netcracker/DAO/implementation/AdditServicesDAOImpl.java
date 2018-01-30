package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.AdditServicesDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.DAO.entity.Corps;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class AdditServicesDAOImpl extends AbstractDAO implements AdditServicesDAO {

    public AdditServicesDAOImpl() {
    }

    @Override
    protected Session getSession() {
        return super.getSession();
    }

    @Override
    public void persist(Object entity) {
        super.persist(entity);
    }

    @Override
    public void delete(Object entity) {
        super.delete(entity);
    }

    @Override
    public void saveAdditServices(AdditionalServices corps) {
        persist(corps);
    }

    @Override
    public List<AdditionalServices> findAllAdditServices() {
        Criteria criteria = getSession().createCriteria(AdditionalServices.class);
        return (List<AdditionalServices>) criteria.list();
    }

    @Override
    public AdditionalServices findAdditServicesById(int id) {
        Criteria criteria = getSession().createCriteria(Corps.class);
        criteria.add(Restrictions.eq("id", id));
        return (AdditionalServices) criteria.uniqueResult();
    }

    @Override
    public void deleteAdditServicesById(int id) {

    }
}
