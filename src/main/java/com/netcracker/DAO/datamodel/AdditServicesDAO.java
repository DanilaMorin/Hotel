package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.AdditionalServices;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface AdditServicesDAO {
    void saveAdditServices(AdditionalServices corps);

    List<AdditionalServices> findAllAdditServices();

    AdditionalServices findAdditServicesById(int id);

    int deleteAdditServicesById(int id_reserv, int id_service);

}
