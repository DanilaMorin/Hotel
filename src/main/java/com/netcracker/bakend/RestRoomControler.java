package com.netcracker.bakend;

import com.netcracker.DAO.entity.Room;
import com.netcracker.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 18.01.2018.
 */

@RestController
@RequestMapping("/room")
public class RestRoomControler {
    @Autowired
    RoomService roomService;

    @GetMapping("/free")
    Integer getRoomFree(){
        Integer count = 0;
        count = roomService.getRoomFree();
        return count;
    }

    @PostMapping("/free")

    List<Room> getListRoom(String date){

        List<Room> list = null;
        list = roomService.getListRoom(date);
        return list;
    }

    @PostMapping("/add")
    void saveRoom(Room room){
        roomService.saveRoom(room);
    };
    @GetMapping("/getAll")
    List<Room> findAllRoom(){
        return roomService.findAllRoom();
    };
    @PostMapping("/getById")
    Room findRoomById(int id_room,int  id_corp){
        return roomService.findRoomById(id_room,id_corp);
    };
    @DeleteMapping("/delById")
    boolean deleteRoomById(int id_room,int  id_corp){
        int n = roomService.deleteRoomById(id_room,id_corp);
        Boolean b = false;
        if (n > 0) b = true;
        return b;
    };
}
