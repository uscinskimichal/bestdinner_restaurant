package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.RestaurantAccountDto;
import pl.bestdinner.model.RestaurantAccount;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantAccountMapper {
    RestaurantAccountDto convert(RestaurantAccount in);

    RestaurantAccount convert(RestaurantAccountDto in);

    List<RestaurantAccountDto> convert(List<RestaurantAccount> in);
}
