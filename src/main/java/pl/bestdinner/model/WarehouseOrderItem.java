package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Getter
@Setter
@Entity(name = "warehouse_order_item")
public class WarehouseOrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "warehouse_order_item_id")
    private Long tableId;

    @Digits(integer = 5, fraction = 2)
    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_order_id")
    private WarehouseOrder warehouseOrder;
}
