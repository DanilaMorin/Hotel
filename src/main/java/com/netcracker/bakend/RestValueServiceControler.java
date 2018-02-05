package com.netcracker.bakend;

import com.netcracker.DAO.entity.ValueService;
import com.netcracker.services.ValueServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 31.01.2018.
 */
@RestController
@RequestMapping("valServ")
public class RestValueServiceControler {

    @Autowired
    ValueServiceService service;

    @GetMapping("/getAll")
    List<ValueService> getListValueService(){
        List<ValueService> list = null;
        list = service.findAllValueService();
        return  list;
    }

    @GetMapping("/getById/{idcorp}/{idservice}")
    ValueService getValueServiceById(@PathVariable("idcorp") int id_corp, @PathVariable("idservice") int id_service){

        ValueService valueService = service.findValueServiceById(id_corp,id_service);
        return valueService;
    }
    @PostMapping("/add")
    ValueService addValueService(ValueService valueRoom)
    {
        service.saveValueService(valueRoom);
        return valueRoom;
    }

    @DeleteMapping("/del")
    boolean deleteById(int id_corp, int id_service){
        service.deleteValueServiceById(id_corp,id_service);
        return true;
    }
}
