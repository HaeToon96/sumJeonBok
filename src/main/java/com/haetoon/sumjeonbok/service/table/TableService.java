package com.haetoon.sumjeonbok.service.table;

import com.haetoon.sumjeonbok.model.entity.Order;
import com.haetoon.sumjeonbok.repository.OrderRepository;
import com.haetoon.sumjeonbok.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableService {
    private final OrderRepository orderRepository;
    public Order isOrdered(Long id){
       return orderRepository.findByRoomTableId(id).orElse(null);
    }
    public List<Order>orderListCheck(Long id){
        return orderRepository.findAllByRoomTableId(id).orElseThrow();
    }
}
