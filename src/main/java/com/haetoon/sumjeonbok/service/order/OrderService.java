package com.haetoon.sumjeonbok.service.order;

import com.haetoon.sumjeonbok.model.entity.MenuInfo;
import com.haetoon.sumjeonbok.model.entity.Order;
import com.haetoon.sumjeonbok.model.entity.RoomTable;
import com.haetoon.sumjeonbok.model.entity.Status;
import com.haetoon.sumjeonbok.repository.MenuInfoRepository;
import com.haetoon.sumjeonbok.repository.OrderRepository;
import com.haetoon.sumjeonbok.repository.RoomTableRepository;
import com.haetoon.sumjeonbok.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RoomTableRepository roomTableRepository;
    private final StatusRepository statusRepository;
    private final MenuInfoRepository menuInfoRepository;
    private final OrderRepository orderRepository;

    public List<Order> firstOrder(Long id) {
        RoomTable roomTable = roomTableRepository.findById(id).orElse(null);
        List<MenuInfo> menuInfoList = menuInfoRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < menuInfoList.size(); i++) {
            Order order = Order.builder()
                    .roomTable(roomTable)
                    .menuInfo(menuInfoList.get(i))
                    .quantity(0)
                    .totalPrice(0)
                    .orderDate(now)
                    .status(statusRepository.findByName("결제전").orElse(null))
                    .build();
            orderRepository.save(order);
        }
        List<Order> orderList = orderRepository.findAllByRoomTableId(id).orElse(null);
        return orderList;
    }
    public List<Order> order(Long tableId, Long menuId) {
        MenuInfo menuInfo = menuInfoRepository.findById(menuId).orElse(null);
        Order order = orderRepository.findByRoomTableIdAndMenuInfoId(tableId, menuId).orElse(null);
        LocalDateTime now = LocalDateTime.now();
        order.setQuantity(order.getQuantity() + 1);
        int totalPrice = order.getQuantity() * menuInfo.getPrice();
        order.setTotalPrice(totalPrice);
        order.setOrderDate(now);
        orderRepository.save(order);
        return orderRepository.findAllByRoomTableId(tableId).orElseThrow();
    }
    public List<Order>cancel(Long tableId,Long menuId){
        MenuInfo menuInfo = menuInfoRepository.findById(menuId).orElse(null);
        Order order = orderRepository.findByRoomTableIdAndMenuInfoId(tableId,menuId).orElse(null);
        LocalDateTime now = LocalDateTime.now();
        order.setQuantity(order.getQuantity()-1);
        int totalPrice = order.getQuantity() * menuInfo.getPrice();
        order.setTotalPrice(totalPrice);
        order.setOrderDate(now);
        orderRepository.save(order);
        return orderRepository.findAllByRoomTableId(tableId).orElseThrow();
    }
    public List<Order>reset(Long tableId){
        List<Order>orderList = orderRepository.findAllByRoomTableId(tableId).orElse(null);
        for(int i=0; i<orderList.size(); i++){
            orderList.get(i).setQuantity(0);
            orderList.get(i).setTotalPrice(0);
            orderRepository.save(orderList.get(i));
        }
        return orderList;
    }
}
