package com.netcracker.bakend;

import com.netcracker.DAO.entity.Room;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    ResponseEntity getRoomFree(){
        Integer count = 0;
        try {
            count = roomService.getRoomFree();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        } catch (com.netcracker.exception.ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/free")

   ResponseEntity getListRoom(String date){
        List<Room> list = null;
        try {
            list = roomService.getListRoom(date);
            return new ResponseEntity<List<Room>>(list,HttpStatus.OK);
        } catch (com.netcracker.exception.ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    ResponseEntity saveRoom(Room room){
       try {
            roomService.saveRoom(room);
            return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
       }
       catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Such an object already exists", HttpStatus.NOT_FOUND);
       }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<String>("Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    };
    @GetMapping("/getAll")
    ResponseEntity findAllRoom(){
        try {
            List<Room> list = roomService.findAllRoom();
            return new ResponseEntity<List<Room>>(list,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };
    @PostMapping("/getById")
    ResponseEntity findRoomById(int id_room,int  id_corp){
        try {
            Room room  =  roomService.findRoomById(id_room,id_corp);
            return new ResponseEntity<Room>(room,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return  new ResponseEntity<String>(entityNotFound.getMessage(),HttpStatus.NOT_FOUND);
        }
    };
    @DeleteMapping("/delById")
    ResponseEntity deleteRoomById(int id_room,int  id_corp){
        int n = 0;
        try {
            n = roomService.deleteRoomById(id_room,id_corp);
            Boolean b = false;
            if (n > 0) b = true;
            return new ResponseEntity<Boolean>(b,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    };
}
