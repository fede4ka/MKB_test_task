package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.CarAssessedValue;
import org.springframework.data.repository.CrudRepository;

public interface CarsAVRepository extends CrudRepository<CarAssessedValue, Long> {
}