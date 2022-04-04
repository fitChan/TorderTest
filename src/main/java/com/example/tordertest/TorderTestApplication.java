package com.example.tordertest;

import com.example.tordertest.entity.user.Role;
import com.example.tordertest.entity.user.User;
import com.example.tordertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication @EnableJpaAuditing

public class TorderTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TorderTestApplication.class, args);
    }

}
