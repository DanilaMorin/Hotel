package com.netcracker.bakend;

import com.netcracker.DAO.entity.*;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ClientService;
import com.netcracker.services.ReservService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("rest/client")
public class RestClientControler {


    @Autowired
    ClientService clientService;

    @Autowired
    ReservService reservService;
    @GetMapping(value = "/reviews")
    ResponseEntity getMap() {
        try {
            List<ClientReviews> list = clientService.getClientReviews();
            return new ResponseEntity<List<ClientReviews>>((List<ClientReviews>) list, HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping(value = "/add", consumes = "application/json")
    ResponseEntity setAdditServicesServie(@RequestBody Client client) {
        try {
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


    @PostMapping("/dataByID")
    ResponseEntity getData(int id_reserv) {
        try {
            Reserv reserv = reservService.findReservById(id_reserv);
            String login = reserv.getId_client();
            Map<String, Object> result = new HashMap<>();
            Double price = clientService.billForServices(login);
            List<Reviews> list = clientService.getRevByid(login);
            List<ServicePrice> map = clientService.typesOfServices(login);
            result.put("price", price);
            result.put("Reviews", list);
            result.put("ServicePrice", map);
            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        } catch (EntityNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (FatalError e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    ResponseEntity getAll() {
        List<Client> list = null;
        try {
            list = clientService.getClient();
            return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
        } catch (FatalError fatalError) {
            return new ResponseEntity<String>(fatalError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getById")
    ResponseEntity getClientById(String login) {
        try {
            login = Validation.parseStirng(login);
            Client client = clientService.getClientById(login);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (FatalError fatalError) {
            return new ResponseEntity<String>(fatalError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<String>(entityNotFound.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/getDataClient")
    ResponseEntity getDataClient(String login) {
        try {
            login = Validation.parseStirng(login);
            DataClient dataClient = clientService.getDataClient(login);
            return new ResponseEntity<DataClient>(dataClient, HttpStatus.OK);
        } catch (FatalError fatalError) {
            return new ResponseEntity<String>(fatalError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return new ResponseEntity<String>(entityNotFound.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
