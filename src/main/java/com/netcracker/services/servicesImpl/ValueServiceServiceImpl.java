package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.ValueServiceDAO;
import com.netcracker.DAO.entity.ValueService;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ValueServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 31.01.2018.
 */
@Service("valueServiceService")
@Transactional
public class ValueServiceServiceImpl implements ValueServiceService {


    @Autowired
    ValueServiceDAO valueServiceDAO;

    @Override
    public void saveValueService(ValueService valueService) {
        valueServiceDAO.saveValueService(valueService);
    }

    @Override
    public List<ValueService> findAllValueService() throws FatalError {
        return valueServiceDAO.findAllValueService();
    }

    @Override
    public ValueService findValueServiceById(int id_corp, int id_service) throws FatalError, EntityNotFound {
        return valueServiceDAO.findValueServiceById(id_corp,id_service);
    }

    @Override
    public Integer deleteValueServiceById(int id_corp, int id_service) throws FatalError {
      return  valueServiceDAO.deleteValueServiceById(id_corp,id_service);
    }
}
