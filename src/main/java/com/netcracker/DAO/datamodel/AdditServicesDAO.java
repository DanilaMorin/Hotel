package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import org.postgresql.util.PSQLException;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface AdditServicesDAO {
    Boolean saveAdditServices(AdditionalServices corps) ;

    List<AdditionalServices> findAllAdditServices() throws EntityNotFound;

    AdditionalServices findAdditServicesById(int id) throws EntityNotFound;

    int deleteAdditServicesById(int id_reserv, int id_service) throws FatalError;

}
