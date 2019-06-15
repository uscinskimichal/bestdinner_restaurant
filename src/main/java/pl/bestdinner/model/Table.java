package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tables")
public class Table {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "x")
    private Long x;

    @Column(name = "y")
    private Long y;

    @Column(name = "width")
    private Long width;

    @Column(name = "height")
    private Long height;

    @Column(name = "occupied")
    private Boolean occupied; //TODO status stołu

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "orderId")
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
