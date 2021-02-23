package com.javaschool.domainlogic.user.registration.mapper.api;

import com.javaschool.domainlogic.user.registration.dto.Birthday;

import java.time.LocalDate;

/**
 * @author Daria Usova
 */
public interface BirthdayMapper {

    /**
     * Maps birthday to local date.
     *
     * @param birthday the birthday
     * @return the local date
     */
    LocalDate toLocalDate(Birthday birthday);

    /**
     * Maps local date to birthday.
     *
     * @param birthday the birthday
     * @return the birthday
     */
    Birthday toBirthday(LocalDate birthday);

}
