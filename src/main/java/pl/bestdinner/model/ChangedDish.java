package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "changed_dish")
public class ChangedDish {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "changed_dish_id")
    private Long changedDishId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @OneToMany(mappedBy = "changedDish")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "changedDish")
    private Set<ChangedDishIngredient> changedDishIngredientSet;
}
