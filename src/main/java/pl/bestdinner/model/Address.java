package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "address")
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id")
    private int idAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "building_number")
    private String buildingNubmer;

    @Column(name = "apparetment_number")
    private String appartmentNumber;

    @OneToMany(mappedBy = "address")
    private Set<Client> clients;

    @OneToMany(mappedBy = "address")
    private Set<Order> orders;
    
}
