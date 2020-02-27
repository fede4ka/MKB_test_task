package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneAssessedValueDto;
import com.mcb.creditfactory.model.AirplaneAssessedValue;

public interface AirplaneAVService {
    AirplaneAssessedValue save(AirplaneAssessedValue value);
    AirplaneAssessedValue fromDto(AirplaneAssessedValueDto dto);
    Long getId(AirplaneAssessedValue value);
}
