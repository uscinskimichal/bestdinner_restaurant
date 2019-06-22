package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "restaurant_account")
public class RestaurantAccount {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_id")
    private Long idRestaurant;

    @Digits(integer = 7, fraction = 2)
    @Column(name = "balance")
    private BigDecimal balance;
}
