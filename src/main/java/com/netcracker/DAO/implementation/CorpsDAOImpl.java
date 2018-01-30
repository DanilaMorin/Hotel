package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.CorpsDAO;
import com.netcracker.DAO.entity.Corps;
import com.netcracker.DAO.entity.Reserv;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class CorpsDAOImpl extends AbstractDAO implements CorpsDAO
{


    public CorpsDAOImpl() {
    }

    @Override
    public void saveCorps(Corps corps) {
        persist(corps);
    }

    @Override
    public List<Corps> findAllCorps() {
        Criteria criteria = getSession().createCriteria(Corps.class);
        return (List<Corps>) criteria.list();
    }

    @Override
    public Corps findCorpsById(int id) {
        Criteria criteria = getSession().createCriteria(Corps.class);
        criteria.add(Restrictions.eq("id", id));
        return (Corps) criteria.uniqueResult();
    }

    @Override
    public void deleteCorpsById(int id) {

    }
}
