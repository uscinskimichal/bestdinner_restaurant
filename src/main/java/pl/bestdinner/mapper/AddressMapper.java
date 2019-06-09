package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.AddressClientDto;
import pl.bestdinner.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressClientDto convert(Address in);
}
