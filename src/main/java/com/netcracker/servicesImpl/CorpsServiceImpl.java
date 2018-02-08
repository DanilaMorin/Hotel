package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.CorpsDAO;
import com.netcracker.DAO.entity.Corps;
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
    public List<Corps> findAllCorps() {

        return corpsDAO.findAllCorps();
    }

    @Override
    public Corps findCorpsById(int id) {
        Corps corps ;
        try {
            corps = corpsDAO.findCorpsById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            corps = null;
        }
        return corps;
    }

    @Override
    public boolean deleteCorpsById(int id) {
        int n = corpsDAO.deleteCorpsById(id);
        if(n>0) return  true;
        return false;


    }
}
