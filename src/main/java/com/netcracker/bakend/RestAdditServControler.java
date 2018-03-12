package com.netcracker.bakend;

import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.AdditServicesServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping(value = "rest/additserv")

public class RestAdditServControler {

    @Autowired
    AdditServicesServie additServicesServie;



    @PostMapping(value = "/add",consumes = "application/json" )
    ResponseEntity setAdditServicesServie(@RequestBody  AdditionalServices service){
        AdditionalServices services;

        try {
            additServicesServie.saveAdditServices(service);
            return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
        }
        catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Such an object already exists", HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            System.out.println("Error");
            ex.printStackTrace();
            return new ResponseEntity<String>("Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getAll")

    ResponseEntity getById(int id){
        try {
            AdditionalServices services = additServicesServie.findAdditServicesById(id);
            return new ResponseEntity<AdditionalServices>((AdditionalServices) services, HttpStatus.OK);
        }catch (EntityNotFound ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/del",produces ="application/json")

    ResponseEntity deleteById(int id_reserv, int id_service){

        Boolean b = null;
        try {
            b = additServicesServie.deleteAdditServicesById(id_reserv,id_service);
            if (!b) return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (FatalError fatalError) {
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
    @GetMapping("/getAll")

    ResponseEntity getListReserv() {
        try {
            List<AdditionalServices> list = null;
            list = additServicesServie.findAllAdditServices();
            return new ResponseEntity<List<AdditionalServices>> (list, HttpStatus.OK);

        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return new ResponseEntity<String>( entityNotFound.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

