package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Double power;
    @Column(name = "year_of_issue")
    private Short year;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CarAssessedValue> values = new ArrayList<>();
    public BigDecimal getValue() {
      return values.stream().reduce(
                       (e1,e2)-> (e1.assessedDate.before(e2.assessedDate)) ? e2:e1).get().value;
   }
    public Date getAssessedDate() {
        return values.stream().reduce(
                (e1,e2)-> (e1.assessedDate.before(e2.assessedDate)) ? e2:e1).get().assessedDate;
    }
}
