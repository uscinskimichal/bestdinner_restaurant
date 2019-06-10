package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.OrderDto;
import pl.bestdinner.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto convert(Order in);
    Order convert(OrderDto in);
    List<OrderDto> convert(List<Order> in);
}
