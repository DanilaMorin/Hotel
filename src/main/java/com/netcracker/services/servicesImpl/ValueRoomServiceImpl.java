package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.ValueRoomDAO;
import com.netcracker.DAO.entity.ValueRoom;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ValueRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("valueRoomService")
@Transactional
public class ValueRoomServiceImpl implements ValueRoomService{

    @Autowired

    ValueRoomDAO valueRoomDAO;

    @Override
    public void saveValueRoom(ValueRoom valueRoom) {
        valueRoomDAO.saveValueRoom(valueRoom);
    }

    @Override
    public List<ValueRoom> findAllValueRoom() throws FatalError {
        return valueRoomDAO.findAllValueRoom();
    }

    @Override
    public ValueRoom findValueRoomById(int stars, int number) throws FatalError {
        return valueRoomDAO.findValueRoomById(stars,number);
    }

    @Override
    public boolean deleteServiceById(int stars, int number) throws FatalError {
            return valueRoomDAO.deleteValueRoomById(stars,number);
    }
}
