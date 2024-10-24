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
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATUS_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "status",cascade = CascadeType.ALL)
    private List<OrderLog> orderLogList = new ArrayList<>();
}
