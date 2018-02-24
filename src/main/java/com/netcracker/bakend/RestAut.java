package com.netcracker.bakend;

import com.netcracker.config.ReadHtml;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

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
@RequestMapping(value = "login1")//,produces ="text/html")
public ResponseEntity<String>  getLogin(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Model model) {
    model.addAttribute("error", error != null);
    model.addAttribute("logout", logout != null);
    //return "login";
    ModelAndView model1 =  new ModelAndView();
    model1.setViewName("login");
    String str = new ReadHtml("C:\\Users\\12345\\IdeaProjects\\Hotel1.2\\src\\main\\webapp\\login.html").getS();
    System.out.println(str);;
    ResponseEntity<String> responseEntity = new ResponseEntity<String>(str,HttpStatus.OK);

    //HttpServletResponse resp = new HttpServletResponseWrapper();
    return   responseEntity ;
    }


}
