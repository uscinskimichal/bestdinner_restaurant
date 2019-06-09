package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "changed_dish_ingredient")
public class ChangedDishIngredient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "changed_dish_ingredient_id")
    private Integer dishIngredeintId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_dish_id")
    private ChangedDish changedDish;
}
