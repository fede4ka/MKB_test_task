package com.mcb.creditfactory.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CAR_ASSESSED_VALUE")
public class CarAssessedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_id")
    public Long car_id;
    @ManyToOne(targetEntity = Car.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id",insertable=false, updatable=false)
    private Car car;
    BigDecimal value;
    Date assessedDate;
    public CarAssessedValue(Long car_id,BigDecimal value, Date date)
    {
        this.car_id=car_id;
        this.value=value;
        assessedDate =date;
    }
}
