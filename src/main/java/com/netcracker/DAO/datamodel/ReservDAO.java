package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Reserv;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface ReservDAO {
    void saveReserv(Reserv Reserv);

    List<Reserv> findAllReserv();

    Reserv findReservById(int id);

    void deleteReservById(int id);

}
