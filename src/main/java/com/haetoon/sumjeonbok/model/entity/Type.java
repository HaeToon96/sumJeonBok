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
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_ID")
    private long id;
    @Column(name = "MENU_TYPE")
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL)
    private List<MenuInfo>menuInfoList = new ArrayList<>();
}
