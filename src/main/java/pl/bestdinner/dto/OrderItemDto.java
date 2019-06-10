package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemDto {

    private Integer orderItemId;
    private String status;
    private List<ChangedDishDto> changedDish;
    private List<DishDto> dish; //Czy powinno zwracać też listę składników?
}
