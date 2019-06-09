package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name="ingredient")
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingredient_id")
    private Integer ingredientId;

    @Column(name = "name")
    private String name;

    @Column(name = "warehouse_quantity")
    private Double warehouseQuantity;

    @Column(name = "measurement_unit")
    private Double measurementUnit;

    @Column(name = "client_price")
    private Double clientPrice;

    @Column(name = "warehouse_price")
    private Double warehousePrice;

    @Column(name = "is_sold_to_client")
    private Boolean isSoldToClient;

    @OneToMany(mappedBy = "ingredient")
    private Set<DishIngredient> dishIngredientSet;

    @OneToMany(mappedBy = "ingredient")
    private Set<WarehouseOrderItem> warehouseOrderItemSet;


}
