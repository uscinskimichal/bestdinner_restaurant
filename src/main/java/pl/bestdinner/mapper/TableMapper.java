package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.TableDto;
import pl.bestdinner.model.Table;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TableMapper {
    List<TableDto> convert(List<Table> in);
    TableDto convert(Table in);
    Table convert(TableDto in);
}
