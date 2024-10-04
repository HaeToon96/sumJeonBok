package com.haetoon.sumjeonbok.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    @JsonIgnore
    @OneToMany(mappedBy = "roomTable", cascade = CascadeType.ALL)
    private List<Order> orderList=new ArrayList<>();
}
