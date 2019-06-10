package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.OrderItemDto;
import pl.bestdinner.model.OrderItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto convert(OrderItem in);
    OrderItem convert(OrderItemDto in);
    List<OrderItemDto> convert(List<OrderItem> in);
}
