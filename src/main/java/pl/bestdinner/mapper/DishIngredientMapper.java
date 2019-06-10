package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.DishIngredientDto;
import pl.bestdinner.model.DishIngredient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishIngredientMapper {
    DishIngredientDto convert(DishIngredient in);
    List<DishIngredientDto> convert(List<DishIngredient> in);
    DishIngredient  convert(DishIngredientDto in);
}
