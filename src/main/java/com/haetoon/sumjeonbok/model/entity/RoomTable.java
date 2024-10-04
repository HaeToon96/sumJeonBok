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
public class RoomTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_TABLE_ID")
    private long id;
    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "TABLE_ID")
    private MyTable myTable;
    @OneToMany(mappedBy = "roomTable", cascade = CascadeType.ALL)
    private List<Order> orderList=new ArrayList<>();
}
