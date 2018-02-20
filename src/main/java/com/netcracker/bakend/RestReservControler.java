package com.netcracker.bakend;

import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ReservService;
import com.netcracker.DAO.entity.Reserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity getListReserv(){
        List<Reserv> list = null;
        try {
            list = reservService.findAllReserv();
            return  new ResponseEntity<List<Reserv>>(list, HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getResById/{id}")
    ResponseEntity getReservById(@PathVariable("id") int id){
        Reserv reserv = null;
        try {
            reserv = reservService.findReservById(id);
            return new ResponseEntity<Reserv>(reserv,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return new ResponseEntity<String>(entityNotFound.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    ResponseEntity addReserv(Reserv reserv)
    {
        try {
        reservService.saveReserv(reserv);
        return new ResponseEntity<Reserv>(reserv,HttpStatus.OK);
    } catch (DataIntegrityViolationException ex) {
        ex.printStackTrace();
        return new ResponseEntity<String>("Such an object already exists", HttpStatus.NOT_FOUND);
    } catch (Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<String>("Not Added", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @DeleteMapping("/del")
    ResponseEntity deleteById(int id){
        try {
            reservService.deleteReservById(id);
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
