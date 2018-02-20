package com.netcracker.services;

import com.netcracker.DAO.entity.ValueService;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 31.01.2018.
 */
public interface ValueServiceService {
    void saveValueService(ValueService valueService);

    List<ValueService> findAllValueService() throws FatalError;

    ValueService findValueServiceById(int id_corp, int id_service) throws FatalError, EntityNotFound;

    Integer deleteValueServiceById(int id_corp, int id_service) throws FatalError;
}
