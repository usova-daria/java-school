package com.javaschool.domainlogic.user.registration.mapper.impl;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import com.javaschool.domainlogic.user.registration.mapper.api.BirthdayMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BirthdayMapperImpl implements BirthdayMapper {

    @Override
    public LocalDate toLocalDate(Birthday birthday) {
        return LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDay());
    }

    @Override
    public Birthday toBirthday(LocalDate birthday) {
        return Birthday.builder()
                .day( birthday.getDayOfMonth() )
                .month( birthday.getMonth() )
                .year( birthday.getYear() )
                .build();
    }

}
