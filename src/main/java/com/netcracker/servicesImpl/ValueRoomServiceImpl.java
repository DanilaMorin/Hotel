package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.ValueRoomDAO;
import com.netcracker.DAO.entity.ValueRoom;
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
    public List<ValueRoom> findAllValueRoom() {
        return valueRoomDAO.findAllValueRoom();
    }

    @Override
    public ValueRoom findValueRoomById(int stars, int number) {
        return valueRoomDAO.findValueRoomById(stars,number);
    }

    @Override
    public void deleteServiceById(int stars, int number) {

    }
}
