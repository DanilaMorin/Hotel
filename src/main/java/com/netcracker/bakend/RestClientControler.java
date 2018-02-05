package com.netcracker.bakend;

import com.netcracker.DAO.entity.*;
import com.netcracker.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/reviews")
    List<ClientReviews> getMap() {
        List<ClientReviews> list = clientService.getClientReviews();
        return list;
    }

    @PostMapping("/add")
    void setAdditServicesServie(Client client){
        clientService.addClient(client);

    }
    @PostMapping("/dataByID")
    Map<String, Object> getData(String login) {
        Map<String, Object> map = new HashMap<>();

        Double price = clientService.billForServices(login);
        List<Reviews> list = clientService.getRevByid(login);
        List <ServicePrice> map1 = clientService.typesOfServices(login);
        map.put("Price", price);
        map.put("Reviews", list);
        map.put("Services", map1);

        return map;

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

}
