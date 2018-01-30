package com.netcracker.services;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.DAO.entity.Reserv;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface CorpsService {
    void saveCorps(Corps corps);
    List<Corps> findAllCorps();
    Corps findCorpsById(int id);
    void deleteCorpsById(int id);


}
