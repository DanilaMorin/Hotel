package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.OrganizationDAO;
import com.netcracker.DAO.entity.Organization;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("organizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDAO dao;

    @Override
    public void saveOrg(Organization org) {
        dao.saveOrg(org);

    }

    @Override
    public List<Organization> findAllOrg() throws EntityNotFound, FatalError {
        List<Organization> list = null;
        list = dao.findAllOrg();
        return list;
    }

    @Override
    public Organization findOrgById(String id) throws FatalError, EntityNotFound {
        Organization org = null;
        org = dao.findOrgById(id);
        return org;
    }

    @Override
    public boolean deleteOrgById(String id) throws FatalError {
        return dao.deleteOrgById(id);

    }
}
