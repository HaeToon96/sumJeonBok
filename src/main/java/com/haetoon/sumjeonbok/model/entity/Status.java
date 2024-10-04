package com.haetoon.sumjeonbok.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATUS_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "status",cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();
}
