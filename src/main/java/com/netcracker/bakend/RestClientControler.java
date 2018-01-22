package com.netcracker.bakend;

import com.netcracker.DAO.datamodel.ClientsDAO;
import com.netcracker.DAO.entity.Client;
import com.netcracker.DAO.entity.Reviews;
import com.netcracker.DAO.implementation.ClientsDAOImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController()
public class RestClientControler {

    @RequestMapping("/hello1")
    String index1(){
        return "My";
    }

    @GetMapping("/client/reviews")
    Map<Client,Reviews> getMap()
    {



        ClientsDAO clientsDAO = new ClientsDAOImpl();
        Map<Client, Reviews> map;
        try {
            map = clientsDAO.getClientReviews();
        } catch (SQLException e) {
            e.printStackTrace();
            map = null;
        }

        return map;
    }

    @PostMapping("client/dataByID")
    Map<String,Object> getData(String login){
        ClientsDAO clientsDAO = new ClientsDAOImpl();
        Map<String, Object> map = new HashMap<>();
        try {
            Double price = clientsDAO.billForServices(login);
            List<Reviews> list = clientsDAO.getRevByid(login);
            Map<String,Double> map1 = clientsDAO.typesOfServices(login);
            map.put("Price",price);
            map.put("Reviews",list);
            map.put("Services", map1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }
}
