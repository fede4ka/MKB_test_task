package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.*;
import com.mcb.creditfactory.service.airplane.AirplaneAVService;
import com.mcb.creditfactory.service.car.CarAVService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssessedValueService {
    @Autowired
    private CarAVService carAVService;
    @Autowired
    private AirplaneAVService airplaneAVService;

    public Long saveAssessedValue(AssessedValue object) {
        if ((object instanceof CarAssessedValueDto)) {

            CarAssessedValueDto carAV = (CarAssessedValueDto) object;

            return Optional.of(carAV)
                    .map(carAVService::fromDto)
                    .map(carAVService::save)
                    .map(carAVService::getId)
                    .orElse(null);
        }
        if ((object instanceof AirplaneAssessedValueDto)) {
           AirplaneAssessedValueDto planeAV = (AirplaneAssessedValueDto) object;
           return Optional.of(planeAV)
                   .map(airplaneAVService::fromDto)
                   .map(airplaneAVService::save)
                   .map(airplaneAVService::getId)
                   .orElse(null);
        }
        else {
            throw new IllegalArgumentException();
        }
}
}

