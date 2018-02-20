package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Room;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface RoomDAO {
    Integer getRoomFree() throws  com.netcracker.exception.ParseException, FatalError;
    List<Room> getListRoom(String date) throws com.netcracker.exception.ParseException, FatalError;
    void saveRoom(Room room);
    List<Room> findAllRoom() throws FatalError;
    Room findRoomById(int id_room,int  id_corp) throws EntityNotFound, FatalError;
    int deleteRoomById(int id_room,int  id_corp) throws FatalError;
    List<Client> certainTime(String data, String data1) throws  com.netcracker.exception.ParseException, FatalError;

}
