package pl.bestdinner.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "rooms")
public class Room {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @OneToMany(mappedBy = "room")
    private Set<Table> tables;
}
