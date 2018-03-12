package com.netcracker.bakend;

import com.netcracker.DAO.entity.Room;
import com.netcracker.DAO.entity.RoomCast;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.MyParseException;
import com.netcracker.exception.MyValidationException;
import com.netcracker.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 12345 on 18.01.2018.
 */

@RestController
@RequestMapping("rest/room")
public class RestRoomControler {
    @Autowired
    RoomService roomService;

    @GetMapping("/free")
    ResponseEntity getRoomFree(){
        int count = 0;
        try {
            count = roomService.getRoomFree();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        } catch (MyParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/free")

   ResponseEntity getListRoom(String sdate){
        List<Room> list = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");

            Date date = new Date();
            java.sql.Date datesql = new java.sql.Date(format.parse(format.format(date)).getTime());

            Date date1 = new Date(format.parse(sdate).getTime());
            java.sql.Date datesql1 = new java.sql.Date(format.parse(format.format(date1)).getTime());

            if ( datesql.getTime() >= datesql1.getTime()) {
                list = roomService.getListRoom(sdate);
            } else throw new MyValidationException("Invalid date");
            return new ResponseEntity<List<Room>>(list,HttpStatus.OK);
        } catch (MyParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MyValidationException errorValidation) {
            errorValidation.printStackTrace();
            return new ResponseEntity<String>(errorValidation.getMessage(),HttpStatus.NOT_FOUND);
        }catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Parse error", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    ResponseEntity saveRoom(@RequestBody RoomCast room) {
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
            List<RoomCast> list = roomService.findAllRoom();
            return new ResponseEntity<List<RoomCast>>(list,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };
    @PostMapping("/getById")
    ResponseEntity findRoomById(int id_room,int  id_corp){
        try {
            RoomCast room = roomService.findRoomById(id_room, id_corp);
            return new ResponseEntity<RoomCast>(room, HttpStatus.OK);
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
        try {
            boolean b = roomService.deleteRoomById(id_room,id_corp);
            if (!b) return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return  new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    };
}
