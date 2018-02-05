package com.netcracker.bakend;

import com.netcracker.DAO.entity.Service;
import com.netcracker.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController
@RequestMapping("/service")
public class RestServiceControler {

    @Autowired
    ServiceService serviceService;


    @GetMapping("/getAll")
    List<Service> getListService(){
        List<Service> list = null;
        list = serviceService.findAllService();
        return  list;
    }

    @GetMapping("/getById/{id}")
    Service getServiceById(@PathVariable("id") int id){

        Service service = serviceService.findServiceById(id);
        return service;
    }
    @PostMapping("/add")
    Service addReserv(Service reserv)
    {
        serviceService.saveService(reserv);
        return reserv;
    }

    @DeleteMapping("/del")
    boolean deleteById(int id){
        serviceService.deleteServiceById(id);
        return true;
    }

}
