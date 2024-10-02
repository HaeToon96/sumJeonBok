package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TableRepository extends JpaRepository<MyTable,Long> {
}
