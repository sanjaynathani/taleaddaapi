package com.taleadda.restapi.repository;

import com.taleadda.restapi.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
