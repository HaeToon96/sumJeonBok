package com.haetoon.sumjeonbok.controller;

import com.haetoon.sumjeonbok.model.entity.MenuInfo;
import com.haetoon.sumjeonbok.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @GetMapping("/menuManagement")
    public String menuManage(Model model){
        List<MenuInfo> menuInfoList = menuService.getAllMenuInfo();
        model.addAttribute("menuList",menuInfoList);
        return "table/updateTable";
    }
}
