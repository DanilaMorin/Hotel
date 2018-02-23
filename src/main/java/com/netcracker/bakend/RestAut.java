package com.netcracker.bakend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 12345 on 22.02.2018.
 */

@RestController
public class RestAut {

    @RequestMapping(value = {"/"})
    public ModelAndView welcomePage() {
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Tutorial");
//        model.addObject("message", "Welcome Page !");
//        model.setViewName("helloworld");
//        return model;
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        return model;
    }

//    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
//    public ResponseEntity protectedPage() {
//
//        //        ModelAndView model = new ModelAndView();
//        //        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
//        //        model.addObject("message", "This is protected page - Only for Admin Users!");
//        //        model.setViewName("protected");
//        //        return model;
//            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//    }

//    @RequestMapping(value = "/confidential**", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
//        model.addObject("message", "This is confidential page - Need Super Admin Role!");
//        model.setViewName("protected");
//
//        return model;
//
//    }
}
