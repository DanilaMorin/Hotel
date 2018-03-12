package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.CorpsDAO;
import com.netcracker.DAO.entity.Corps;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("corpsService")
@Transactional
public class CorpsServiceImpl implements CorpsService {

    public CorpsServiceImpl() {
    }

    @Autowired
    private CorpsDAO corpsDAO;

    @Override
    public boolean saveCorps(Corps corps) {
       Boolean b = true;
       try {
           corpsDAO.saveCorps(corps);
       }catch (Exception ex){
           b = false;
       }
       return b;

    }

    @Override
    public List<Corps> findAllCorps() throws EntityNotFound {

        return corpsDAO.findAllCorps();
    }

    @Override
    public Corps findCorpsById(int id) throws FatalError, EntityNotFound {
        Corps corps ;
        corps = corpsDAO.findCorpsById(id);
        return corps;
    }

    @Override
    public boolean deleteCorpsById(int id) throws FatalError {
        boolean n = corpsDAO.deleteCorpsById(id);
        return n;


    }
}
