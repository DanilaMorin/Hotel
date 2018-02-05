package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ValueRoomDAO;
import com.netcracker.DAO.entity.ValueRoom;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class ValueRoomDAOImpl extends AbstractDAO implements ValueRoomDAO{

    public ValueRoomDAOImpl() {
    }

    @Override
    public void saveValueRoom(ValueRoom valueRoom) {
        persist(valueRoom);
    }

    @Override
    public List<ValueRoom> findAllValueRoom() {
        Criteria criteria = getSession().createCriteria(ValueRoom.class);
        return (List<ValueRoom>) criteria.list();
    }

    @Override
    public ValueRoom findValueRoomById(int stars, int number) {
        Criteria criteria = getSession().createCriteria(ValueRoom.class);
        criteria.add(Restrictions.eq("stars", stars));
        criteria.add(Restrictions.eq("number",number));
        return (ValueRoom) criteria.uniqueResult();
    }

    @Override
    public void deleteValueRoomById(int stars, int number) {

    }
}
