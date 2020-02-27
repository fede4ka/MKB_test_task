package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneAssessedValueDto;
import com.mcb.creditfactory.model.AirplaneAssessedValue;
import com.mcb.creditfactory.repository.AirplaneAVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneAVServiceImpl implements AirplaneAVService {
    @Autowired
    private AirplaneAVRepository repository;
    @Override
    public AirplaneAssessedValue save(AirplaneAssessedValue value) {
        return repository.save(value);
    }
    @Override
    public AirplaneAssessedValue fromDto(AirplaneAssessedValueDto dto) {
        return new AirplaneAssessedValue(
                dto.getAirplane_id(),
                dto.getValue(),
                dto.getAssessedDate());
    }
    @Override
    public Long getId(AirplaneAssessedValue value) {
       return value.getId();
    }
}
