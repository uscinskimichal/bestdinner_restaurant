package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity(name="ingredient")
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "name")
    private String name;

    @Column(name = "warehouse_quantity")
    private Double warehouseQuantity;

    @Digits(integer=5, fraction=2)
    @Column(name = "client_price")
    private BigDecimal clientPrice;

    @Digits(integer=5, fraction=2)
    @Column(name = "warehouse_price")
    private BigDecimal warehousePrice;

    @Column(name = "is_sold_to_client")
    private Boolean isSoldToClient;

    @OneToMany(mappedBy = "ingredient")
    private Set<DishIngredient> dishIngredientSet;

    @OneToMany(mappedBy = "ingredient")
    private Set<WarehouseOrderItem> warehouseOrderItemSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

}
