package com.haetoon.sumjeonbok.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "ROOM_TABLE_ID")
    private RoomTable roomTable;
    @ManyToOne
    @JoinColumn(name  = "MENU_INFO_ID")
    private MenuInfo menuInfo;
    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private Status status;

    public Order() {
    }

    @Builder
    public Order(int quantity, int totalPrice, LocalDateTime orderDate, RoomTable roomTable, MenuInfo menuInfo, Status status) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.roomTable = roomTable;
        this.menuInfo = menuInfo;
        this.status = status;
    }
}
