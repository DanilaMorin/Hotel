package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.ValueRoom;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
public interface ValueRoomDAO {

    void saveValueRoom(ValueRoom valueRoom);

    List<ValueRoom> findAllValueRoom() throws FatalError;

    ValueRoom findValueRoomById(int stars, int number) throws FatalError;

    boolean deleteValueRoomById(int stars, int number) throws FatalError;

}
