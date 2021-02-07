package com.javaschool.domainlogic.user.registration.dto;

import lombok.Data;

import java.time.Month;

@Data
public class Birthday {

    private int day;
    private Month month;
    private int year;

}
