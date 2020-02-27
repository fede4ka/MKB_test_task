package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
    private AirplaneDto dto;
    @Override
    public BigDecimal getValue() {
        return dto.getValue();
    }
    @Override
    public Short getYear() {
        return dto.getYear();
    }
    @Override
    public LocalDate getDate() {
        return dto.getAssessedDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
