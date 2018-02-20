package com.netcracker.bakend;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController
@RequestMapping("/corps")
public class RestCorpsControler {

    @Autowired
    CorpsService corpsService;

    @GetMapping("/getAll")
    ResponseEntity getListReserv() {
        try {
            List<Corps> list = corpsService.findAllCorps();
            return new ResponseEntity<List<Corps>>(list,HttpStatus.OK);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<String>(entityNotFound.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/add",consumes = "application/json")
    ResponseEntity setAdditServicesServie(@RequestBody Corps corps) {
        try {
            Boolean b = corpsService.saveCorps(corps);
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
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
        boolean b = false;
        try {
            b = corpsService.deleteCorpsById(id);
            if(!b) return new ResponseEntity<Boolean>(false,HttpStatus.EXPECTATION_FAILED);
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }

    @PostMapping("/getAll")
    ResponseEntity getById(int id){
        try {
            Corps corps = null;
            corps = corpsService.findCorpsById(id);
            return new ResponseEntity<Corps>(corps,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return new ResponseEntity<String>(entityNotFound.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
