package com.netcracker.bakend;

import com.netcracker.DAO.entity.Service;
import com.netcracker.DAO.entity.ValueRoom;
import com.netcracker.services.ValueRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController
@RequestMapping("/valRoom")
public class RestValueRoomControler {

    @Autowired
    ValueRoomService service;

    @GetMapping("/getAll")
    List<ValueRoom> getListValueRoom(){
        List<ValueRoom> list = null;
        list = service.findAllValueRoom();
        return  list;
    }

    @GetMapping("/getById/{stars}/{number}")
    ValueRoom getValueRoomById(@PathVariable("stars") int stars,@PathVariable("number") int number){

        ValueRoom valueRoom = service.findValueRoomById(stars,number);
        return valueRoom;
    }
    @PostMapping("/add")
    ValueRoom addValueRoom(ValueRoom valueRoom)
    {
        service.saveValueRoom(valueRoom);
        return valueRoom;
    }

    @DeleteMapping("/del")
    boolean deleteById(int stars, int number){
        service.deleteServiceById(stars,number);
        return true;
    }
}
