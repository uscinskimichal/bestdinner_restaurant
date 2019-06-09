package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "dish")
public class Dish {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dish_id")
    private Integer idDish;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "dish")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "dish")
    private Set<DishIngredient> dishIngredientSet;

    @OneToMany(mappedBy = "dish")
    private Set<ChangedDish> changedDishSet;

}
