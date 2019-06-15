package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "measurement_unit")
public class MeasurementUnit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "measurement_unit_id")
    private Long measurementUnitId;
    @Column(name = "name")
    private String name;
    @Column(name = "must_be_integer")
    private Boolean mustBeInteger;
}
