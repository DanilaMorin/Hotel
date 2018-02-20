package com.netcracker.services;

import com.netcracker.DAO.entity.Service;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface ServiceService {
    void saveService(Service service);

    List<Service> findAllService() throws FatalError;

    Service findServiceById(int id) throws FatalError, EntityNotFound;

    Integer deleteServiceById(int id) throws FatalError;
}
