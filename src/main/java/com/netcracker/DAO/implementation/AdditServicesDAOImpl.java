package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.AdditServicesDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        Criteria criteria = getSession().createCriteria(AdditionalServices.class);
        criteria.add(Restrictions.eq("id", id));
        return (AdditionalServices) criteria.uniqueResult();
    }

    @Override
    public int   deleteAdditServicesById(int id_reserv, int id_service) {
        Query query =  getSession().createQuery("delete AdditionalServices where id_reserv = :id_reserv and id_service = :id_service");
        query.setParameter("id_reserv", id_reserv);
        query.setParameter("id_service", id_service);
        int result = query.executeUpdate();
        //System.out.println(result);
        return result;
    }
}
