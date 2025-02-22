package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status,Long> {
    Optional<Status> findByName(String name);
}
