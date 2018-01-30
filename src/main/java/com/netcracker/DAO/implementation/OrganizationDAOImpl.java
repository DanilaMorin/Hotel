package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.OrganizationDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.DAO.entity.Corps;
import com.netcracker.DAO.entity.Organization;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
    public List<Organization> findAllOrg() {
        Criteria criteria = getSession().createCriteria(Organization.class);
        return (List<Organization>) criteria.list();

    }

    @Override
    public Organization findOrgById(String id) {
        Criteria criteria = getSession().createCriteria(Organization.class);
        criteria.add(Restrictions.eq("id", id));
        return (Organization) criteria.uniqueResult();
    }

    @Override
    public void deleteOrgById(String id) {

    }
}
