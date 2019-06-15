package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.DishStatusDto;
import pl.bestdinner.model.DishStatus;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishStatusMapper {
    DishStatusDto convert(DishStatus in);
    DishStatus convert(DishStatusDto in);
    List<DishStatusDto> convert(List<DishStatus> in);
}
