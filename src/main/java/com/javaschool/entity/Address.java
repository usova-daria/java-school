package com.javaschool.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "apartment")
    private String apartment;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "town_id")
    private Town town;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

}
