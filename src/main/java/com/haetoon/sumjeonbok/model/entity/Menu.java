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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="MENU_ID")
    private long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<MenuInfo>menuInfoList = new ArrayList<>();
}
