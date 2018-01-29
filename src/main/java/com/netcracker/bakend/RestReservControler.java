package com.netcracker.bakend;

import com.netcracker.DAO.datamodel.ReservDAO;
import com.netcracker.DAO.datamodel.ReservService;
import com.netcracker.DAO.entity.Reserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 29.01.2018.
 */
@RestController
@RequestMapping("/reserv")
public class RestReservControler {
    @Autowired
    ReservService reservService;


    @GetMapping("/getAll")
    List<Reserv> getListReserv(){
        List<Reserv> list = null;
         list = reservService.findAllReserv();
        return  list;
    }

    @GetMapping("/getResById/{id}")
    Reserv getReservById(@PathVariable("id") int id){

        Reserv reserv = reservService.findReservById(id);
        return reserv;
    }
    @PostMapping("/add")
    Reserv addReserv(Reserv reserv)
    {
        reservService.saveReserv(reserv);
        return reserv;
    }

    @DeleteMapping("/del")
    boolean deleteById(int id){
        reservService.deleteReservById(id);
        return true;
    }

}
