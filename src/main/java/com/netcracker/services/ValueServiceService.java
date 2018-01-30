package com.netcracker.services;

import com.netcracker.DAO.entity.ValueService;

import java.util.List;

/**
 * Created by 12345 on 31.01.2018.
 */
public interface ValueServiceService {
    void saveValueService(ValueService valueService);

    List<ValueService> findAllValueService();

    ValueService findValueServiceById(int id_corp, int id_service);

    void deleteValueServiceById(int id_corp, int id_service);
}
