package com.netcracker.bakend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 * Created by 12345 on 17.01.2018.
 */
@RestController()
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello Spring";
    }
}
