package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.WarehouseOrderItemDto;
import pl.bestdinner.model.WarehouseOrderItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WarehouseOrderItemMapper {

    WarehouseOrderItemDto convert(WarehouseOrderItem in);
    WarehouseOrderItem convert(WarehouseOrderItemDto in);
    List<WarehouseOrderItemDto> convert(List<WarehouseOrderItem> in);
}
