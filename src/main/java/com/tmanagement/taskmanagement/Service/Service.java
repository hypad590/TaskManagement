package com.tmanagement.taskmanagement.Service;

import com.tmanagement.taskmanagement.Model.User;
import com.tmanagement.taskmanagement.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository repos;
    User user;
    public void setValues(String requested){
        user = new User();
        user.setUserName(requested);
        user.setId(requested);

        repos.save(user);
    }
}
