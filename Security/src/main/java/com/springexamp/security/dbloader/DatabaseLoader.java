package com.springexamp.security.dbloader;

import com.springexamp.security.enums.Role;
import com.springexamp.security.model.User;
import com.springexamp.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class DatabaseLoader {
    private UserRepository repo;
    public DatabaseLoader(UserRepository repo){
        this.repo = repo;
    }

    @Bean
    public CommandLineRunner initializeDatabase(){
        return args -> {
          User user1 = new User("admin@gmail.com", "admin123", Role.ADMIN);
          User user2 = new User("atakan@gmail.com", "atakan123", Role.ADMIN);
          User user3 = new User("goksuozcn@gmail.com", "goksu123", Role.USER);
          User user4 = new User("lastuser@gmail.com", "last123", Role.USER);

          repo.saveAll(List.of(user1,user2,user3,user4));

            System.out.println("Sample database initialized");
        };
    }
}
