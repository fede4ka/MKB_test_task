package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarAssessedValueDto.class),
        @JsonSubTypes.Type(value = AirplaneAssessedValueDto.class)
})
public interface AssessedValue {
}
