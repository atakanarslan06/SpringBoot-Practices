package com.springexamp.security.repository;

import com.springexamp.security.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
