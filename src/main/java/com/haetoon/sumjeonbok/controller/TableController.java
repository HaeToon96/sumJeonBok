package com.haetoon.sumjeonbok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TableController {

    @GetMapping("/table/{id}")
    public String table(@PathVariable int id , Model model){
        return "table/table";
    }
}
