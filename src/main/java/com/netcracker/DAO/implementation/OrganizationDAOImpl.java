package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.OrganizationDAO;
import com.netcracker.DAO.entity.Organization;
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
public class OrganizationDAOImpl extends AbstractDAO implements OrganizationDAO {

    public OrganizationDAOImpl() {
    }



    @Override
    public void saveOrg(Organization corps) {
            persist(corps);
    }

    @Override
    public List<Organization> findAllOrg() throws EntityNotFound, FatalError {
        try {
            Criteria criteria = getSession().createCriteria(Organization.class);
            List<Organization> list = (List<Organization>) criteria.list();
            if(list == null) throw new EntityNotFound("NoOrganizations");
            return list;
         }catch (Exception ex){
             ex.printStackTrace();
        throw new FatalError("base is not responding");
         }
    }

    @Override
    public Organization findOrgById(String id) throws EntityNotFound, FatalError {
        try {
            Criteria criteria = getSession().createCriteria(Organization.class);
            criteria.add(Restrictions.eq("id", id));
            Organization organization = (Organization) criteria.uniqueResult();
            if (organization == null) throw new EntityNotFound("NoOrganization");
            return organization;
        }catch (EntityNotFound ex){
            throw new EntityNotFound(ex.getMessage());
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw  new FatalError("base is not responding");
        }
        }

    @Override
    public boolean deleteOrgById(String id) throws FatalError {
     try {
        Query query =  getSession().createQuery("delete Organization where login = :id ");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        if(result > 0 ) return  true;
        else return false;
    }
        catch (Exception ex){
        ex.printStackTrace();
        throw new FatalError("base is not responding");
    }
    }
}
