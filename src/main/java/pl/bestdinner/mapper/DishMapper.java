package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.DishDto;
import pl.bestdinner.model.Dish;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishDto convert(Dish in);
    List<DishDto> convert(List<Dish> in);
    Dish convert(DishDto in);
}
