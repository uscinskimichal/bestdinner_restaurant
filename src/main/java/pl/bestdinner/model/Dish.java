package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity(name = "dish")
public class Dish {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dish_id")
    private Long idDish;

    @Column(name = "name")
    private String name;

    @Digits(integer = 5, fraction = 2)
    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "dish")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "dish")
    private Set<DishIngredient> dishIngredientSet;

    @OneToMany(mappedBy = "dish")
    private Set<ChangedDish> changedDishSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dishType_id")
    private DishType dishType;


}
