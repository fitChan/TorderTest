package com.example.tordertest.repository;

import com.example.tordertest.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<Menu> findById(Long menuId);

}
