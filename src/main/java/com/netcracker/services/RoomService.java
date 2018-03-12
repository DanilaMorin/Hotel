package com.netcracker.services;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Room;
import com.netcracker.DAO.entity.RoomCast;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.MyParseException;

import java.util.List;

/**
 * Created by user on 05.02.2018.
 */


public interface RoomService {
    int getRoomFree() throws MyParseException, FatalError;

    List<Room> getListRoom(String date) throws MyParseException, FatalError;

    void saveRoom(RoomCast room);
    List<RoomCast> findAllRoom() throws FatalError;

    RoomCast findRoomById(int id_room, int id_corp) throws FatalError, EntityNotFound;
    boolean deleteRoomById(int id_room,int  id_corp) throws FatalError;

    List<Client> certainTime(String data, String data1) throws MyParseException, FatalError;

}
