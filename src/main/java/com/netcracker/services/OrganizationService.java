package com.netcracker.services;

import com.netcracker.DAO.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */

public interface OrganizationService {
    void saveOrg(Organization corps);

    List<Organization> findAllOrg();

    Organization findOrgById(String id);

    void deleteOrgById(String id);
}
