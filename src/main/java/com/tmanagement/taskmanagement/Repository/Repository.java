package com.tmanagement.taskmanagement.Repository;

import com.tmanagement.taskmanagement.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<User,String> {
    User findByUserName(String userName);
    User findByEmail(String email);

}
