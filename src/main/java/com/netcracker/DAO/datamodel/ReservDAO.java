package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Reserv;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface ReservDAO {
    void saveReserv(Reserv Reserv);

    List<Reserv> findAllReserv() throws FatalError;

    Reserv findReservById(int id) throws EntityNotFound, FatalError;

    int deleteReservById(int id) throws FatalError;

}
