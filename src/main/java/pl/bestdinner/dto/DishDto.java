package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DishDto {

    private Integer idDish;

    private String name;

    private Double price;

    private List<DishIngredientDto> dishIngredientSet;

}
