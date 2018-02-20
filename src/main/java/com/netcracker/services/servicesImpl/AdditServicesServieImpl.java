package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.AdditServicesDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.AdditServicesServie;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("addServService")
@Transactional
public class AdditServicesServieImpl implements AdditServicesServie  {

    public AdditServicesServieImpl() {
    }

    @Autowired
    private AdditServicesDAO additServicesDAO ;

    @Override
public Boolean saveAdditServices(AdditionalServices services) {
        Boolean b;
        try {
            b =  additServicesDAO.saveAdditServices(services);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;


    }return b;
    }

    @Override
    public List<AdditionalServices> findAllAdditServices() throws EntityNotFound{

        return additServicesDAO.findAllAdditServices();
    }

    @Override
    public AdditionalServices findAdditServicesById(int id) throws EntityNotFound {
        return additServicesDAO.findAdditServicesById(id);
    }

    @Override
    public boolean deleteAdditServicesById(int id_reserv, int id_service) throws FatalError {
        int rez = additServicesDAO.deleteAdditServicesById(id_reserv, id_service);
        boolean b = false;
        if (rez > 0) b = true;
        return b;
    }
}
