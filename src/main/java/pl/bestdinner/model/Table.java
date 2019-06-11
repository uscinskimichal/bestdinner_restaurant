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
    private Integer tableId;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "status")
    private Integer status;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "table")
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
