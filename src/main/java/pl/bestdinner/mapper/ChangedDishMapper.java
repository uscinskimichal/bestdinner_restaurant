package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.ChangedDishDto;
import pl.bestdinner.model.ChangedDish;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChangedDishMapper {
    ChangedDishDto convert(ChangedDish in);
    ChangedDish convert(ChangedDishDto in);
    List<ChangedDishDto> convert(List<ChangedDish> in);
}
