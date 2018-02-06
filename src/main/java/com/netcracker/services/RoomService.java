package com.netcracker.services;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.DataClient;
import com.netcracker.DAO.entity.Room;

import java.util.List;

/**
 * Created by user on 05.02.2018.
 */


public interface RoomService {
    Integer getRoomFree() ;
    List<Room> getListRoom(String date) ;
    void saveRoom(Room room);
    List<Room> findAllRoom();
    Room findRoomById(int id_room,int  id_corp);
    int deleteRoomById(int id_room,int  id_corp);
    List<Client> certainTime(String data, String data1);

}
