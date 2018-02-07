package com.netcracker.bakend;

import com.netcracker.DAO.entity.AdditionalServices;

import com.netcracker.services.AdditServicesServie;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController()
@RequestMapping(value = "/additserv")
public class RestAdditServControler {

    @Autowired
    AdditServicesServie additServicesServie;


    @PostMapping(value = "/add",consumes = "application/json" )
    ResponseEntity<Boolean> setAdditServicesServie(@RequestBody  AdditionalServices service){
        AdditionalServices services;
           try {
               services =  additServicesServie.saveAdditServices(service);
           }catch (Exception ex){
               services = null;
               Logger.getLogger(AdditionalServices.class.getName()).log(Level.SEVERE, null, ex);

           }
        if (services  == null)
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);

    }

    @PostMapping("/getAll")
    ResponseEntity<AdditionalServices> getById(int id){
        AdditionalServices services = additServicesServie.findAdditServicesById(id);
        if (services  == null)
            return new ResponseEntity<AdditionalServices>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<AdditionalServices>((AdditionalServices) services, HttpStatus.OK);
    }

    @DeleteMapping(value = "/del",produces ="application/json")
    ResponseEntity<Boolean> deleteById(int id_reserv, int id_service){

        Boolean b = additServicesServie.deleteAdditServicesById(id_reserv,id_service);
        if (!b){
            return new ResponseEntity<Boolean>(b,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Boolean>(b, HttpStatus.OK);

    }
    @GetMapping("/getAll")
    ResponseEntity<List<AdditionalServices>> getListReserv() {
        List<AdditionalServices> list = null;
        list = additServicesServie.findAllAdditServices();
        if (list == null ) return new ResponseEntity<List<AdditionalServices>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<AdditionalServices>> (list, HttpStatus.OK);

    }
}

