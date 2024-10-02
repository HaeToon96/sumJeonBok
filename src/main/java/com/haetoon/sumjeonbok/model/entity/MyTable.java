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
public class MyTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TABLE_ID")
    private long id;
    @Column(name = "TABLE_NUMBER")
    private int number;
    @OneToMany(mappedBy = "myTable",cascade = CascadeType.ALL)
    private List<RoomTable> roomTableList = new ArrayList<>();


}
