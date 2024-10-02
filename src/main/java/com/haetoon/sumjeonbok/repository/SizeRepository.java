package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size,Long> {
    Optional<Size>findByName(String name);
}
