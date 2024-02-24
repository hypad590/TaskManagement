package com.tmanagement.taskmanagement.Controller;

import com.tmanagement.taskmanagement.Service.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class Controller {
    private Service service;
    @GetMapping("/login")
    public String loginPage(@RequestBody String requested){
        service.setValues(requested);
        return "index";
    }
    @PostMapping("/submit")
    public ModelAndView submit(){
        return new ModelAndView("redirect:/home.html");
    }
    @PostMapping("/createProject")
    public ModelAndView create(){
        service = new Service();
        String path = service.Parse();
        return new ModelAndView(path);
    }

}
