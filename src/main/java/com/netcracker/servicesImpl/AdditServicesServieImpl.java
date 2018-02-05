package com.netcracker.servicesImpl;

import com.netcracker.DAO.datamodel.AdditServicesDAO;
import com.netcracker.DAO.entity.AdditionalServices;
import com.netcracker.services.AdditServicesServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("addServService")
@Transactional
public class AdditServicesServieImpl implements AdditServicesServie {



    public AdditServicesServieImpl() {
    }



    @Autowired
    private AdditServicesDAO additServicesDAO ;

    @Override
    public void saveAdditServices(AdditionalServices corps) {


    }

    @Override
    public List<AdditionalServices> findAllAdditServices() {

        return additServicesDAO.findAllAdditServices();
    }

    @Override
    public AdditionalServices findAdditServicesById(int id) {
        return null;
    }

    @Override
    public boolean deleteAdditServicesById(int id_reserv, int id_service) {
            int rez = additServicesDAO.deleteAdditServicesById(id_reserv, id_service);
        boolean b = false;
        if (rez > 0) b = true;
        return b;
    }
}
