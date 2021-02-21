package com.javaschool.domainlogic.products.record.dto;

import lombok.Data;

import java.time.Year;

@Data
public class RecordDto {

    private Long id;
    private float price;
    private int unitsInStore;
    private boolean available;
    private String name;
    private String picture;
    private String description;
    private String albumName;
    private Year year;
    private String genre;
    private String musicians;

}
