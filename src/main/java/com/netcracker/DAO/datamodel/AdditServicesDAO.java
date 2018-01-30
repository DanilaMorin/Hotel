package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.DAO.entity.Corps;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface AdditServicesDAO {
    void saveAdditServices(AdditionalServices corps);

    List<AdditionalServices> findAllAdditServices();

    AdditionalServices findAdditServicesById(int id);

    void deleteAdditServicesById(int id);

}
