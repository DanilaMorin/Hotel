package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Reserv;

import java.util.List;

/**
 * Created by 12345 on 29.01.2018.
 */
public interface ReservService {
    void saveReserv(Reserv reserv);
    List<Reserv> findAllReserv();
    Reserv findReservById(int id);
    void deleteReservById(int id);

}

