package com.haetoon.sumjeonbok.controller;

import com.haetoon.sumjeonbok.model.entity.MenuInfo;
import com.haetoon.sumjeonbok.model.entity.Order;
import com.haetoon.sumjeonbok.model.entity.RoomTable;
import com.haetoon.sumjeonbok.repository.MenuInfoRepository;
import com.haetoon.sumjeonbok.repository.OrderRepository;
import com.haetoon.sumjeonbok.repository.RoomTableRepository;
import com.haetoon.sumjeonbok.repository.StatusRepository;
import com.haetoon.sumjeonbok.service.menu.MenuService;
import com.haetoon.sumjeonbok.service.order.OrderService;
import com.haetoon.sumjeonbok.service.table.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TableController {
    private final TableService tableService;
    private final MenuService menuService;
    private final OrderService orderService;
    @GetMapping("/table/{id}")
    public String table(@PathVariable Long id , Model model){
        List<Order>orderList = tableService.orderListCheck(id);
        if(orderList.isEmpty()){
            System.out.println("주문 정보가 없습니다");
            List<Order>orderList2 = orderService.firstOrder(id);
            model.addAttribute("orderList",orderList2);
        }else {
            System.out.println("주문 정보가 있습니다.");
            model.addAttribute("orderList",orderList);
        }
        return "table/table";
    }
}
