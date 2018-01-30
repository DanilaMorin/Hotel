package com.netcracker.bakend;

import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.DAO.entity.Corps;
import com.netcracker.services.AdditServicesServie;
import com.netcracker.services.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController()
public class RestAdditServControler {
    //@Qualifier("getAdditServicesServie")
    @Autowired
    AdditServicesServie additServicesServie;

    @GetMapping("/addd/getAll")
    List<AdditionalServices> getListReserv() {
        List<AdditionalServices> list = null;
        list = additServicesServie.findAllAdditServices();
        // list = reservDAO.findAllReserv();
        return list;

    }
}

