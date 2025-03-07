package com.carwash.S.I_car_wash.converter;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null) {
            return "";
        }
        return String.join(",", attribute);  // List<String> එක string එකක් ලෙස Join කිරීම
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        return List.of(dbData.split(","));  // string එකෙහි කොමාවෙන් වෙන් කර, List<String> එකක් වෙයි
    }
}
