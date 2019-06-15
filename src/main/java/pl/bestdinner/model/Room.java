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
    private Long roomId;

    @Column(name = "width")
    private Long width;

    @Column(name = "height")
    private Long height;

    @OneToMany(mappedBy = "room")
    private Set<Table> tables;
}
