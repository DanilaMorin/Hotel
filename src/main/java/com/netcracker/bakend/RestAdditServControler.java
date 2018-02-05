package com.netcracker.bakend;

import com.netcracker.DAO.entity.AdditionalServices;

import com.netcracker.services.AdditServicesServie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController()
@RequestMapping("/additserv")
public class RestAdditServControler {

    @Autowired
    AdditServicesServie additServicesServie;


    @PostMapping("/add")
    void setAdditServicesServie(AdditionalServices servie){
        additServicesServie.saveAdditServices(servie);

    }

    @PostMapping("/getAll")
    AdditionalServices getById(int id){
        return additServicesServie.findAdditServicesById(id);
    }

    @DeleteMapping("/del")
    boolean deleteById(int id_reserv, int id_service){

        Boolean b = additServicesServie.deleteAdditServicesById(id_reserv,id_service);
        return b;
    }
    @GetMapping("/getAll")
    List<AdditionalServices> getListReserv() {
        List<AdditionalServices> list = null;
        list = additServicesServie.findAllAdditServices();
        return list;

    }
}

