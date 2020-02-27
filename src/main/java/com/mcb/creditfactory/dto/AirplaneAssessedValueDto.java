package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplaneAV")
public class AirplaneAssessedValueDto implements AssessedValue{
    Long airplane_id;
    BigDecimal value;
    Date assessedDate;
}
