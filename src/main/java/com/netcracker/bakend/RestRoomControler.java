package com.netcracker.bakend;

import com.netcracker.DAO.entity.Room;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.ErrorValidation;
import com.netcracker.exception.FatalError;
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
            }else throw new ErrorValidation("Invalid date");
            return new ResponseEntity<List<Room>>(list,HttpStatus.OK);
        } catch (com.netcracker.exception.ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ErrorValidation errorValidation) {
            errorValidation.printStackTrace();
            return new ResponseEntity<String>(errorValidation.getMessage(),HttpStatus.NOT_FOUND);
        }catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Parse error", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    ResponseEntity saveRoom(@RequestBody Room room){
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
