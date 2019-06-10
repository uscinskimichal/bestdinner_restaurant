package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.ChangedDishIngredientDto;
import pl.bestdinner.model.ChangedDishIngredient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChangedDishIngredientMapper {
    ChangedDishIngredientDto convert(ChangedDishIngredient in);
    List<ChangedDishIngredientDto> convert(List<ChangedDishIngredient> in);
    ChangedDishIngredient  convert(ChangedDishIngredientDto in);
}
