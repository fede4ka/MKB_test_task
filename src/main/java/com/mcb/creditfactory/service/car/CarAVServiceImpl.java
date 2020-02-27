package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarAssessedValueDto;
import com.mcb.creditfactory.model.CarAssessedValue;
import com.mcb.creditfactory.repository.CarsAVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarAVServiceImpl implements CarAVService {
    @Autowired
    private CarsAVRepository repository;
    @Override
    public CarAssessedValue save(CarAssessedValue carAV) {
        return repository.save(carAV);
    }
    @Override
    public CarAssessedValue fromDto(CarAssessedValueDto dto) {
        return new CarAssessedValue(
                dto.getCar_id(),
                dto.getValue(),
                dto.getAssessedDate()
        );
    }

    @Override
    public Long getId(CarAssessedValue carav) {
        return carav.getId();
    }
}
