package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "dish_status")
public class DishStatus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dish_status_id")
    private Long dishStatusId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<OrderItem> orderItems;
}
