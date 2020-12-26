package com.javaschool.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_info_id")
    private long id;

    @Column(name = "bonuses")
    private int bonuses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }
}
