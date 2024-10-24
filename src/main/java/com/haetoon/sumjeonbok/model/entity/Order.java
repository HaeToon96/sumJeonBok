package com.haetoon.sumjeonbok.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MyOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long id;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "TOTAL_PRICE")
    private int totalPrice;
    @ManyToOne
    @JoinColumn(name = "ROOM_TABLE_ID")
    private RoomTable roomTable;
    @ManyToOne
    @JoinColumn(name  = "MENU_INFO_ID")
    private MenuInfo menuInfo;
    @JsonIgnore
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderLog>orderLogList = new ArrayList<>();
    public Order() {
    }

    @Builder
    public Order(int quantity, int totalPrice, RoomTable roomTable, MenuInfo menuInfo) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.roomTable = roomTable;
        this.menuInfo = menuInfo;
    }
}
