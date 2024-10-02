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
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIZE_ID")
    private long id;
    @Column(name = "MENU_SIZE")
    private String name;
    @OneToMany(mappedBy = "size",cascade = CascadeType.ALL)
    private List<MenuInfo>menuInfoList = new ArrayList<>();
}
