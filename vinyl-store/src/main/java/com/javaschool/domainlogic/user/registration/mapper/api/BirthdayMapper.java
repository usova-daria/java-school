package com.javaschool.domainlogic.user.registration.mapper.api;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public interface BirthdayMapper {

    LocalDate toLocalDate(Birthday birthday);

    Birthday toBirthday(LocalDate birthday);

}
