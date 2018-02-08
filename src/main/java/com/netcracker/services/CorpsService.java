package com.netcracker.services;

import com.netcracker.DAO.entity.Corps;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface CorpsService {
    boolean saveCorps(Corps corps);
    List<Corps> findAllCorps();
    Corps findCorpsById(int id);
    boolean  deleteCorpsById(int id);


}
