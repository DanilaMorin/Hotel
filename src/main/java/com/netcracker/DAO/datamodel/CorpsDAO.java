package com.netcracker.DAO.datamodel;


import com.netcracker.DAO.entity.Corps;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface CorpsDAO {
    void saveCorps(Corps corps);

    List<Corps> findAllCorps();

    Corps findCorpsById(int id);

    int deleteCorpsById(int id);
}
