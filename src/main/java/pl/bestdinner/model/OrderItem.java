package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;
import pl.bestdinner.dto.StatusDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name="order_item")
public class OrderItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_item_id")
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_dish_id")
    private ChangedDish changedDish;

    @OneToMany(mappedBy = "orderItem")
    private Set<OrderItemHistory> orderItemHistorySet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;    //TODO status do każdego dania w zamówieniu z osobna?

}
