package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Room;

import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface RoomDAO {
    Integer getRoomFree() throws ParseException;
    List<Room> getListRoom(String date) throws ParseException;
    void saveRoom(Room room);
    List<Room> findAllRoom();
    Room findRoomById(int id_room,int  id_corp);
    int deleteRoomById(int id_room,int  id_corp);
    List<Client> certainTime(String data, String data1) throws ParseException;

}
