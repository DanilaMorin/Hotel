package com.netcracker.bakend;

import com.netcracker.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

/**
 * Created by user on 02.02.2018.
 */
@RestController
public class RestTest {

    @Autowired
    RoomService roomService;
    @PostMapping("/test")
    void getTest(String login)
    {
        String date = "2018-01-23";
        System.out.println(roomService.getListRoom(date));
    }
}
