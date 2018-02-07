package com.netcracker.bakend;

import com.netcracker.DAO.entity.*;
import com.netcracker.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("/client")
public class RestClientControler {


    @Autowired
    ClientService clientService;

    @GetMapping(value = "/reviews")
    ResponseEntity<List<ClientReviews>> getMap() {
        List<ClientReviews> list = clientService.getClientReviews();
        if (list  == null)
            return new ResponseEntity<List<ClientReviews>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<ClientReviews>> ((List<ClientReviews>) list, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Boolean> setAdditServicesServie(Client client){
        Boolean b = clientService.addClient(client);
        if (!b)
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);

        return new ResponseEntity<Boolean> (true, HttpStatus.OK);
    }
    @PostMapping("/dataByID")
    ResponseEntity<Map<String, Object>> getData(String login) {
        Map<String, Object> map = new HashMap<>();

        Double price = clientService.billForServices(login);
        List<Reviews> list = clientService.getRevByid(login);
        List <ServicePrice> map1 = clientService.typesOfServices(login);
        System.out.println(price);
        System.out.println(list);
        System.out.println(map1);
       if ((price.equals(-1.0)) & (list == null) & (map1 == null))
           map = null;
        if (map == null) return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_FOUND);
        map.put("price", price);
        map.put("Reviews",list);
        map.put("ServicePrice", map1);
        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK );

    }

    @PostMapping("/getAll")
    List<Client> getAll(){
        List<Client> list = clientService.getClient();
        return list;
    }

    @PostMapping("/getById")
    Client getClientById(String login){
        return clientService.getClientById(login);
    }

    @PostMapping("/getDataClient")
    DataClient getDataClient(String login){
        return clientService.getDataClient(login);
    }
}
