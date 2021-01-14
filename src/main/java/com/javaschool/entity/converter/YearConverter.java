package com.javaschool.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year year) {
        if (year == null) {
            return null;
        }
        
        return (short) year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short yearDb) {
        if (yearDb == null) {
            return null;
        }

        return Year.of(yearDb);
    }
}
