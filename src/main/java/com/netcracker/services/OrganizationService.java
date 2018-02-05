package com.netcracker.services;

import com.netcracker.DAO.entity.Organization;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */

public interface OrganizationService {
    void saveOrg(Organization corps);

    List<Organization> findAllOrg();

    Organization findOrgById(String id);

    int deleteOrgById(String id);
}
