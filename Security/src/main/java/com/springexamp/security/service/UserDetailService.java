package com.springexamp.security.service;

import com.springexamp.security.CustomUserDetails;
import com.springexamp.security.model.User;
import com.springexamp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailService implements UserDetailsService {

    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("No user found");
        }
        return new CustomUserDetails(user);

    }
}
