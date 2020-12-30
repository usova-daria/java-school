package com.javaschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private List<Town> towns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

}
