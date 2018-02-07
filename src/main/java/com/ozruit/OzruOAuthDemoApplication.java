package com.ozruit;

import com.ozruit.entities.Role;
import com.ozruit.entities.User;
import com.ozruit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Arrays;

@SpringBootApplication
public class OzruOAuthDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OzruOAuthDemoApplication.class, args);
    }

    @Autowired
    public void authanticationManager(AuthenticationManagerBuilder builder, UserRepo userRepo) throws Exception {
        builder.userDetailsService(s -> new CustomUserDetails(userRepo.findByUsername(s)));
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepo repo) {
        return args -> {
            if (repo.count() == 0) {
                System.out.println("new user created");
                repo.save(new User("user", "user", Arrays.asList(new Role("ROLER_USER"))));
            }
        };
    }
}
