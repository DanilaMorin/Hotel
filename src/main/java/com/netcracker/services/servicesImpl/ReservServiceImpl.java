package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.ReservDAO;
import com.netcracker.DAO.entity.Reserv;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ReservService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 29.01.2018.
 */
@Service("reservService")
@Transactional
public class ReservServiceImpl implements ReservService {


    @Autowired
    private ReservDAO reservDAO ;

    public void saveReserv(Reserv contact) {
        reservDAO.saveReserv(contact);
    }

    public List<Reserv> findAllReserv() throws FatalError {
        return reservDAO.findAllReserv();
    }

    public Reserv findReservById(int id) throws FatalError, EntityNotFound {
        return reservDAO.findReservById(id);
    }

    public int  deleteReservById(int id) throws FatalError {
        return reservDAO.deleteReservById(id);
    }


}


