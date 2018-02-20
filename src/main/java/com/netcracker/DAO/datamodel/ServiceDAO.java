package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Service;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface ServiceDAO {

    void saveService(Service service);

    List<Service> findAllService() throws FatalError;

    Service findServiceById(int id) throws EntityNotFound, FatalError;

    Integer deleteServiceById(int id) throws FatalError;
}
