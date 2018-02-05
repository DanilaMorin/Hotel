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
    public void saveCorps(Corps corps) {
        corpsDAO.saveCorps(corps);
    }

    @Override
    public List<Corps> findAllCorps() {

        return corpsDAO.findAllCorps();
    }

    @Override
    public Corps findCorpsById(int id) {
        return corpsDAO.findCorpsById(id);
    }

    @Override
    public int deleteCorpsById(int id) {
        return corpsDAO.deleteCorpsById(id);

    }
}
