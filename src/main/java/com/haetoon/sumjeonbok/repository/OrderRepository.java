package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByRoomTableId(Long id);
    Optional<Order>findByRoomTableIdAndMenuInfoId(Long roomTableId,Long MenuInfoId);
    Optional<List<Order>>findAllByRoomTableId(Long id);
}
