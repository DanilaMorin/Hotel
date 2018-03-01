package com.netcracker.bakend;

import com.netcracker.DAO.entity.Client;
import com.netcracker.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 12345 on 22.02.2018.
 */

@RestController
public class RestAut {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = {"/"})
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = {"/rest"})
    public ModelAndView getSwagger() {
        ModelAndView model = new ModelAndView();
        model.setViewName("swagger");

        return model;
    }

    @RequestMapping(value = "/login")
    public Model getLogin(@RequestParam(value = "error", required = false) String error,
                          @RequestParam(value = "logout", required = false) String logout,
                          Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return model;

    }

    @PostMapping(value = "/client/add")
    ResponseEntity setAdditServicesServie(String login, String password, String surname, String name, String middle_name, String sex, String email) {
        try {
            Client client = new Client(login, password, surname, name, middle_name, sex, email);
            client.parseString();
            clientService.addClient(client);
            return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
        } catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Such an object already exists", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            System.out.println("Error");
            ex.printStackTrace();
            return new ResponseEntity<String>("Not Added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
