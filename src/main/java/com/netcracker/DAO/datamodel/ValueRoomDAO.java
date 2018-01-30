package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Service;
import com.netcracker.DAO.entity.ValueRoom;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface ValueRoomDAO {

    void saveValueRoom(ValueRoom valueRoom);

    List<ValueRoom> findAllValueRoom();

    ValueRoom findValueRoomById(int stars, int number);

    void deleteValueRoomById(int stars, int number);

}
