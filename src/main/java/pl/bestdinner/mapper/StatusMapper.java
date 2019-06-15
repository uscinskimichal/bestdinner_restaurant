package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.StatusDto;
import pl.bestdinner.model.Status;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusDto convert(Status in);
    Status convert(StatusDto in);
    List<StatusDto> convert(List<Status> in);
}
