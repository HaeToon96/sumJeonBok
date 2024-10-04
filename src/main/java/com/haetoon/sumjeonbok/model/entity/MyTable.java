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
public class MyTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TABLE_ID")
    private long id;
    @Column(name = "TABLE_NUMBER")
    private int number;
    @JsonIgnore
    @OneToMany(mappedBy = "myTable",cascade = CascadeType.ALL)
    private List<RoomTable> roomTableList = new ArrayList<>();


}
