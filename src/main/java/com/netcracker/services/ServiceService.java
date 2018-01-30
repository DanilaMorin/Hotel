package com.netcracker.services;

import com.netcracker.DAO.entity.Service;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface ServiceService {
    void saveService(Service service);

    List<Service> findAllService();

    Service findServiceById(int id);

    void deleteServiceById(int id);
}
