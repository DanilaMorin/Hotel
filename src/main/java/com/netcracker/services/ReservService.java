package com.netcracker.services;

import com.netcracker.DAO.entity.Reserv;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 29.01.2018.
 */
public interface ReservService {
    void saveReserv(Reserv reserv);
    List<Reserv> findAllReserv() throws FatalError;
    Reserv findReservById(int id) throws FatalError, EntityNotFound;
    int deleteReservById(int id) throws FatalError;

}

