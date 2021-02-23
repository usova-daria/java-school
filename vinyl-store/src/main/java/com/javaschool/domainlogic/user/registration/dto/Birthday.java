package com.javaschool.domainlogic.user.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

/**
 * @author Daria Usova
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Birthday {

    private int day;
    private Month month;
    private int year;

}
