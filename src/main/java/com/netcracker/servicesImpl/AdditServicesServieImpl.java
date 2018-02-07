package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.AdditServicesDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.services.AdditServicesServie;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
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
    public AdditionalServices saveAdditServices(AdditionalServices services) {
        try {
            services =  additServicesDAO.saveAdditServices(services);
        }
        catch (Exception ex) {
            Logger.getLogger(AdditionalServices.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
            return null;


    }return services;
    }

    @Override
    public List<AdditionalServices> findAllAdditServices() {

        return additServicesDAO.findAllAdditServices();
    }

    @Override
    public AdditionalServices findAdditServicesById(int id) {
        return additServicesDAO.findAdditServicesById(id);
    }

    @Override
    public boolean deleteAdditServicesById(int id_reserv, int id_service) {
        int rez = additServicesDAO.deleteAdditServicesById(id_reserv, id_service);
        boolean b = false;
        if (rez > 0) b = true;
        return b;
    }
}
