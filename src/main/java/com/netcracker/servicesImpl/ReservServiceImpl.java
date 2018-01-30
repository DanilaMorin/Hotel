package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.ReservDAO;
import com.netcracker.DAO.entity.Reserv;
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

    public List<Reserv> findAllReserv() {
        return reservDAO.findAllReserv();
    }

    public Reserv findReservById(int id) {
        return reservDAO.findReservById(id);
    }

    public void deleteReservById(int id) {
        reservDAO.deleteReservById(id);
    }


}


