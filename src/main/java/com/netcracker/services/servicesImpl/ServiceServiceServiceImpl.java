package com.netcracker.services.servicesImpl;


import com.netcracker.DAO.datamodel.ServiceDAO;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("serviceService")
@Transactional
public class ServiceServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceDAO serviceDAO;


    @Override
    public void saveService(com.netcracker.DAO.entity.Service service) {
        serviceDAO.saveService(service);
    }

    @Override
    public List<com.netcracker.DAO.entity.Service> findAllService() throws FatalError {
        return serviceDAO.findAllService();
    }

    @Override
    public com.netcracker.DAO.entity.Service findServiceById(int id) throws FatalError, EntityNotFound {
        return serviceDAO.findServiceById(id);
    }

    @Override
    public boolean deleteServiceById(int id) throws FatalError {
            return serviceDAO.deleteServiceById(id);
    }
}
