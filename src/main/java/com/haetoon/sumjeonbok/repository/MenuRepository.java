package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    Optional<Menu>findByName(String name);
}
