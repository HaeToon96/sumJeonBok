package com.haetoon.sumjeonbok.controller;

import com.haetoon.sumjeonbok.model.entity.Order;
import com.haetoon.sumjeonbok.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/order")
    @ResponseBody
    public List<Order> order(@RequestParam Long tableId, @RequestParam Long menuId){
        return orderService.order(tableId,menuId);
    }
    @PostMapping("/cancel")
    @ResponseBody
    public List<Order> cancel(@RequestParam Long tableId, @RequestParam Long menuId){
        return orderService.cancel(tableId,menuId);
    }
    @PostMapping("/reset")
    @ResponseBody
    public List<Order> reset(@RequestParam Long tableId){
        return orderService.reset(tableId);
    }
}
