package com.netcracker.services;

import com.netcracker.DAO.entity.Organization;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */

public interface OrganizationService {
    void saveOrg(Organization corps);

    List<Organization> findAllOrg() throws EntityNotFound, FatalError;

    Organization findOrgById(String id) throws FatalError, EntityNotFound;

    boolean deleteOrgById(String id) throws FatalError;
}
