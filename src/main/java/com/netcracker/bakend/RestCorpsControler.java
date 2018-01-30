package com.netcracker.bakend;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.DAO.entity.Reserv;
import com.netcracker.services.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController
public class RestCorpsControler {

    //@Qualifier("getCorpService")
    @Autowired
    CorpsService corpsService;

    @GetMapping("/add/getAll")
    List<Corps> getListReserv() {
        List<Corps> list = null;
        list = corpsService.findAllCorps();
        // list = reservDAO.findAllReserv();
        return list;

    }
}
