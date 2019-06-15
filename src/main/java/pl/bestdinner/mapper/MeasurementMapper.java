package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.MeasurementUnitDto;
import pl.bestdinner.model.MeasurementUnit;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {
    MeasurementUnitDto convert(MeasurementUnit in);
    MeasurementUnit convert(MeasurementUnitDto in);
    List<MeasurementUnitDto> convert(List<MeasurementUnit> in);
}
