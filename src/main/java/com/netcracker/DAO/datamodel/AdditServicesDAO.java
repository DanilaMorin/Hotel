package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.AdditionalServices;
import org.postgresql.util.PSQLException;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface AdditServicesDAO {
    AdditionalServices saveAdditServices(AdditionalServices corps) throws PSQLException;

    List<AdditionalServices> findAllAdditServices();

    AdditionalServices findAdditServicesById(int id);

    int deleteAdditServicesById(int id_reserv, int id_service);

}
