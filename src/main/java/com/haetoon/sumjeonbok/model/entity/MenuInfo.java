package com.haetoon.sumjeonbok.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class MenuInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "MENU_INFO_ID")
    private long id;
    private int cost;
    private int price;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private Type type;
    @ManyToOne
    @JoinColumn( name = "SIZE_ID")
    private Size size;
    @OneToMany(mappedBy = "menuInfo",cascade = CascadeType.ALL)
    private List<Order>orderList=new ArrayList<>();
    public MenuInfo() {
    }
@Builder
    public MenuInfo(int cost, int price, Menu menu, Type type, Size size) {
        this.cost = cost;
        this.price = price;
        this.menu = menu;
        this.type = type;
        this.size = size;
    }
}
