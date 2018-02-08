package com.netcracker.bakend;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.services.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ResponseEntity<List<Corps>> getListReserv() {
        List<Corps> list = null;
        list = corpsService.findAllCorps();
        if (list == null) return new ResponseEntity<List<Corps>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Corps>>(list,HttpStatus.OK);
    }

    @PostMapping(value = "/add",consumes = "application/json")
    ResponseEntity<Boolean> setAdditServicesServie(@RequestBody Corps corps){

        Boolean b = corpsService.saveCorps(corps);
        if(!b) return new ResponseEntity<Boolean>(false,HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }


    @DeleteMapping("/del")
    ResponseEntity<Boolean> deleteById(int id){
        boolean b = corpsService.deleteCorpsById(id);
        if(!b) return new ResponseEntity<Boolean>(false,HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);

    }

    @PostMapping("/getAll")
    ResponseEntity<Corps> getById(int id){
        Corps corps = corpsService.findCorpsById(id);
        if(corps == null) return  new ResponseEntity<Corps>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Corps>(corps,HttpStatus.OK);
    }

}
