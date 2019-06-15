package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "status")
public class Status {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status_id")
    private Long roomId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<Order> orders;

    @OneToMany(mappedBy = "status")
    private Set<OrderItem> orderItems;
}
