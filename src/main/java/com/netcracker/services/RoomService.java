package com.netcracker.services;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.DataClient;
import com.netcracker.DAO.entity.Room;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 05.02.2018.
 */


public interface RoomService {
    Integer getRoomFree() throws  com.netcracker.exception.ParseException, FatalError;
    List<Room> getListRoom(String date) throws com.netcracker.exception.ParseException, FatalError;
    void saveRoom(Room room);
    List<Room> findAllRoom() throws FatalError;
    Room findRoomById(int id_room,int  id_corp) throws FatalError, EntityNotFound;
    int deleteRoomById(int id_room,int  id_corp) throws FatalError;
    List<Client> certainTime(String data, String data1) throws com.netcracker.exception.ParseException, FatalError;

}
