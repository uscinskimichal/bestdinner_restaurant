package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.IngredientDto;
import pl.bestdinner.model.Ingredient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientDto convert(Ingredient in);
    Ingredient convert(IngredientDto in);
    List<IngredientDto> convert(List<Ingredient> in);
}
