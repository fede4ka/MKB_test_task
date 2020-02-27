package com.mcb.creditfactory.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "AIRPLANE_ASSESSED_VALUE")
public class AirplaneAssessedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "airplane_id")
    public Long airplane_id;
    @ManyToOne(targetEntity = Airplane.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id", referencedColumnName = "id",insertable=false, updatable=false)
    private Airplane airplane;
    BigDecimal value;
    Date assessedDate;

    public AirplaneAssessedValue(Long airplane_id,BigDecimal value, Date date) {
        this.airplane_id=airplane_id;
        this.value=value;
        assessedDate =date;
    }
}
