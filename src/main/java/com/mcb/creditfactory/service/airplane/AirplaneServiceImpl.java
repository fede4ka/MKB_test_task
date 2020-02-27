package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.AirplaneAssessedValue;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    private ExternalApproveService approveService;
    @Autowired
    private AirplaneRepository repository;

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return repository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return repository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        List<AirplaneAssessedValue> values = new ArrayList<>();
        values.add((new AirplaneAssessedValue(dto.getId(),dto.getValue(),
                dto.getAssessedDate())));
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuelCapacity(),
                dto.getSeats(),
                values);
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuelCapacity(),
                airplane.getSeats(),
                airplane.getValue(),
                airplane.getAssessedDate());
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}
