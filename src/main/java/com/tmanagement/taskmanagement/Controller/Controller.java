package com.tmanagement.taskmanagement.Controller;

import com.tmanagement.taskmanagement.Service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Service service;
    @GetMapping("/login")
    public String loginPage(@RequestBody String requested){
        service.setValues(requested);
        return "index";
    }

}
