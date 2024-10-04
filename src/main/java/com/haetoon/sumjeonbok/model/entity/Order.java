package com.haetoon.sumjeonbok.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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
    private String orderDate;
    @ManyToOne
    @JoinColumn(name = "ROOM_TABLE_ID")
    private RoomTable roomTable;
    @ManyToOne
    @JoinColumn(name  = "MENU_INFO_ID")
    private MenuInfo menuInfo;
    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private Status status;
}
