package com.netcracker.bakend;

import com.netcracker.DAO.entity.Room;
import com.netcracker.DAO.implementation.RoomDAOImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by 12345 on 18.01.2018.
 */

@RestController
public class RestRoomControler {

    @GetMapping("/room/free")
    int getRoomFree(){

        RoomDAOImpl roomDAO = new RoomDAOImpl();
        int count = 0;

            count = roomDAO.getRoomFree();

        return count;
    }

    @PostMapping("/room/free")

    List<Room> getListRoom(String date){
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        List<Room> list = null;

            list = roomDAO.getListRoom(date);

        System.out.println(list);
        return list;
    }
}
