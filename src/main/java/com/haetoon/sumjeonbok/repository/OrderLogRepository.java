package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository<OrderLog,Long> {

}
