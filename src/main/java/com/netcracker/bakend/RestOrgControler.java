package com.netcracker.bakend;

import com.netcracker.DAO.entity.Organization;
import com.netcracker.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@RestController
@RequestMapping("/org")
public class RestOrgControler {

    @Autowired
    OrganizationService service;
    @GetMapping("/getAll")
    List<Organization> getAll(){
        List<Organization> list = null;
        list = service.findAllOrg();
        return list;
    }

    @PostMapping("/add")
    void setOrg(Organization org){
        service.saveOrg(org);

    }

    @PostMapping("/getAll")
    Organization getById(String id){
        return service.findOrgById(id);
    }

    @DeleteMapping("/del")
    boolean deleteById(String id){
        boolean b = false;
        int n = service.deleteOrgById(id);
        if(n > 0) b = true;
        return b;
    }

}
