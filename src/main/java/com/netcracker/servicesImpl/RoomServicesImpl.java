package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.RoomDAO;
import com.netcracker.DAO.entity.Room;
import com.netcracker.DAO.implementation.RoomDAOImpl;
import com.netcracker.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 05.02.2018.
 */
@Service
@Transactional
public class RoomServicesImpl implements RoomService {
    @Autowired
    RoomDAO roomDAO;

    @Override
    public Integer getRoomFree() {
        Integer count = 0;

        try {
            count  = roomDAO.getRoomFree();
        } catch (ParseException e) {
            e.printStackTrace();
            count = null;
        }
        return count;
    }

    @Override
    public List<Room> getListRoom(String date) {
        List<Room> list;
        try {
            list  = roomDAO.getListRoom(date);
        } catch (ParseException e) {
            e.printStackTrace();
            list = null;

        }
        return list;
    }

    @Override
    public void saveRoom(Room room) {
        roomDAO.saveRoom(room);
    }

    @Override
    public List<Room> findAllRoom() {
        return roomDAO.findAllRoom();
    }

    @Override
    public Room findRoomById(int id_room, int id_corp) {
        return roomDAO.findRoomById(id_room,id_corp);
    }

    @Override
    public int deleteRoomById(int id_room, int id_corp) {
        return roomDAO.deleteRoomById(id_room,id_corp);
    }
}
