package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarAssessedValueDto;
import com.mcb.creditfactory.model.CarAssessedValue;

public interface CarAVService {
    CarAssessedValue save(CarAssessedValue car);
    CarAssessedValue fromDto(CarAssessedValueDto dto);
    Long getId(CarAssessedValue value);
}
