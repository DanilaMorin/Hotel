package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.RoomDAO;
import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Room;
import com.netcracker.DAO.entity.RoomCast;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.exception.MyParseException;
import com.netcracker.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public int getRoomFree() throws MyParseException, FatalError {
        int count;
            count = roomDAO.getRoomFree();
            return count;
    }

    @Override
    public List<Room> getListRoom(String date) throws MyParseException, FatalError {
            List<Room> list;
            list  = roomDAO.getListRoom(date);
        return list;
    }

    @Override
    public void saveRoom(RoomCast room) {
        roomDAO.saveRoom(room);
    }

    @Override
    public List<RoomCast> findAllRoom() throws FatalError {
        return roomDAO.findAllRoom();
    }

    @Override
    public RoomCast findRoomById(int id_room, int id_corp) throws FatalError, EntityNotFound {
        return roomDAO.findRoomById(id_room,id_corp);
    }

    @Override
    public boolean deleteRoomById(int id_room, int id_corp) throws FatalError {
        return roomDAO.deleteRoomById(id_room,id_corp);
    }

    @Override
    public List<Client> certainTime(String data, String data1) throws MyParseException, FatalError {
        List<Client> list;
            list = roomDAO.certainTime(data, data1);
        return list;

    }


}