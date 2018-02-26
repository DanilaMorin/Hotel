package com.netcracker.bakend;

import com.netcracker.DAO.entity.Service;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ServiceService;
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
@RequestMapping("rest/service")
public class RestServiceControler {

    @Autowired
    ServiceService serviceService;


    @GetMapping("/getAll")
    ResponseEntity getListService()  {
        List<Service> list = null;
        try {
            list = serviceService.findAllService();
            return  new ResponseEntity<List<Service>>(list, HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getById/{id}")
    ResponseEntity getServiceById(@PathVariable("id") int id)  {
        Service service = null;
        try {
            service = serviceService.findServiceById(id);
            return new ResponseEntity<Service>(service,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return new ResponseEntity<String>(entityNotFound.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/add")
   ResponseEntity addReserv(@RequestBody Service service)
    {
        try {
            service.setName(Validation.parseStirng(service.getName()));
            serviceService.saveService(service);
            return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
        } catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Such an object already exists", HttpStatus.NOT_FOUND);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<String>("Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @DeleteMapping("/del")
    ResponseEntity deleteById(int id){
        int n = 0;
        try {
            n = serviceService.deleteServiceById(id);
            Boolean b = false;
            if (n > 0) b = true;
            return new ResponseEntity<Boolean>(b,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
