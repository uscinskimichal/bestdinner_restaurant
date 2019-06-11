package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.WarehouseOrderDto;
import pl.bestdinner.model.WarehouseOrder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WarehouseOrderMapper {

    WarehouseOrderDto convert(WarehouseOrder in);
    WarehouseOrder convert(WarehouseOrderDto in);
    List<WarehouseOrderDto> convert(List<WarehouseOrder> in);
}
