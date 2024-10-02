package com.haetoon.sumjeonbok.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;
    private String name;
    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<MenuInfo>menuInfoList = new ArrayList<>();
}
