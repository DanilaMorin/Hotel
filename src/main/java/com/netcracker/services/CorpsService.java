package com.netcracker.services;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface CorpsService {
    boolean saveCorps(Corps corps);
    List<Corps> findAllCorps() throws EntityNotFound;
    Corps findCorpsById(int id) throws FatalError, EntityNotFound;
    boolean  deleteCorpsById(int id) throws FatalError;


}
