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
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_ID")
    private long id;
    @Column(name = "MENU_TYPE")
    String name;
    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL)
    private List<MenuInfo>menuInfoList = new ArrayList<>();
}
