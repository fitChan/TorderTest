package com.example.tordertest.repository;

import com.example.tordertest.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Long userId);
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
