package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.AddressOrderDto;
import pl.bestdinner.model.Address;

@Mapper(componentModel = "spring")
public interface AddressOrderMapper {
    AddressOrderDto convert(Address in);
    Address convert(AddressOrderDto in);
}
