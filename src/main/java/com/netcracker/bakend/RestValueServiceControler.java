package com.netcracker.bakend;

import com.netcracker.DAO.entity.ValueService;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ValueServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 12345 on 31.01.2018.
 */
@RestController
@RequestMapping("rest/valServ")
public class RestValueServiceControler {

    @Autowired
    ValueServiceService service;

    @GetMapping("/getAll")
    ResponseEntity getListValueService(){
        List<ValueService> list = null;
        try {
            list = service.findAllValueService();
            return new ResponseEntity<List<ValueService>>(list,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getById/{idcorp}/{idservice}")
    ResponseEntity getValueServiceById(@PathVariable("idcorp") int id_corp, @PathVariable("idservice") int id_service){
        ValueService valueService = null;
        try {
            valueService = service.findValueServiceById(id_corp,id_service);
            return new ResponseEntity<ValueService>(valueService,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return  new ResponseEntity<String>(entityNotFound.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/add")
    ResponseEntity<String> addValueService(@RequestBody ValueService valueRoom)
    {
        try {
        service.saveValueService(valueRoom);
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
    ResponseEntity deleteById(int id_corp, int id_service){
        int n = 0;
        try {
            n = service.deleteValueServiceById(id_corp, id_service);
            Boolean b = false;
            if (n > 0) b = true;
            return new ResponseEntity<Boolean>(b,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
