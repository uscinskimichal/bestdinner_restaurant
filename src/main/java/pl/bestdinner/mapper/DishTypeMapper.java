package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.DishTypeDto;
import pl.bestdinner.model.DishType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishTypeMapper {
    DishType convert(DishTypeDto in);
    DishTypeDto convert(DishType in);
    List<DishTypeDto> convert(List<DishType> in);
}
