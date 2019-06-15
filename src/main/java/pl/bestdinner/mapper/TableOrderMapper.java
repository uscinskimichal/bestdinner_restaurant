package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.TableOrderDto;
import pl.bestdinner.model.Table;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TableOrderMapper {

    TableOrderDto convert(Table in);
    Table convert(TableOrderDto in);
    List<TableOrderDto> convert(List<Table> in);
}
