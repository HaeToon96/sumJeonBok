package com.haetoon.sumjeonbok.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ORDER_LOG_ID")
    private long id;
    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name="STATUS_ID")
    private Status status;
    @Column(name="ORDER_DATE")
    private LocalDateTime orderDate;
}
