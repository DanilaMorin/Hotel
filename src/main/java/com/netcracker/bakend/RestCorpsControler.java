package com.netcracker.bakend;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.services.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    List<Corps> getListReserv() {
        List<Corps> list = null;
        list = corpsService.findAllCorps();
        return list;
    }

    @PostMapping("/add")
    void setAdditServicesServie(Corps corps){
        corpsService.saveCorps(corps);

    }


    @DeleteMapping("/del")
    boolean deleteById(int id){
        int  n = corpsService.deleteCorpsById(id);
        boolean b = false;
        if(n > 0) b = true;
        return b;

    }

    @PostMapping("/getAll")
    Corps getById(int id){
        return corpsService.findCorpsById(id);
    }

}
