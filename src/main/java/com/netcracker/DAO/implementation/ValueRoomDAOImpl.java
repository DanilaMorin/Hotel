package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ValueRoomDAO;
import com.netcracker.DAO.entity.ValueRoom;
import com.netcracker.exception.FatalError;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
    public List<ValueRoom> findAllValueRoom() throws FatalError {
        try {
            Criteria criteria = getSession().createCriteria(ValueRoom.class);
            List<ValueRoom> list = (List<ValueRoom>) criteria.list();
            return list;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }

    @Override
    public ValueRoom findValueRoomById(int stars, int number) throws FatalError {
     try {
        Criteria criteria = getSession().createCriteria(ValueRoom.class);
        criteria.add(Restrictions.eq("stars", stars));
        criteria.add(Restrictions.eq("number",number));
        return (ValueRoom) criteria.uniqueResult();
    }catch (Exception ex) {
        ex.printStackTrace();
        throw new FatalError("base is not responding");
    }
    }

    @Override
    public boolean deleteValueRoomById(int stars, int number) throws FatalError {
        try {
            Query query = getSession().createQuery("DELETE  ValueRoom as valroom\n" +
                    " WHERE valroom.stars = :stars and valroom.number_of_people = :number_of_people ");
            query.setInteger("stars", stars);
            query.setInteger("number_of_people", number);
            int n = query.executeUpdate();
            if (n > 0 ) return true;
            else return false;
        }catch (Exception ex){
            throw new FatalError("base is not responding");
        }

    }
}
