package com.netcracker.DAO.datamodel;


import com.netcracker.DAO.entity.Corps;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface CorpsDAO {
    void saveCorps(Corps corps);

    List<Corps> findAllCorps() throws EntityNotFound;

    Corps findCorpsById(int id) throws EntityNotFound, FatalError;

    int deleteCorpsById(int id) throws FatalError;
}
