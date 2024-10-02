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
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private long id;
    @Column(name = "ROOM_NAME")
    private String name;
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomTable> roomTableList = new ArrayList<>();
}
