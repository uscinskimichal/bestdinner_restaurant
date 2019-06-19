package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "dish_type")
public class DishType {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dish_type_id")
    private Long dishTypeId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "dish_type")
    private Set<Dish> dishSet;

}
