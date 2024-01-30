package org.toy.dsc.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.format(FORMATTER) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String s) {
        return s != null ? LocalDateTime.parse(s, FORMATTER) : null;
    }
}
