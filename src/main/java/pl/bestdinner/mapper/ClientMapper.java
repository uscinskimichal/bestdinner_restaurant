package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.bestdinner.dto.ClientDto;
import pl.bestdinner.model.Client;

import java.util.List;


@Mapper(componentModel = "spring") //componental model żebyśmy mogli wstrzyknąć tego mappera
public interface ClientMapper {

    ClientDto convert(Client in);

    Client convert(ClientDto in);

    List<ClientDto> convert(List<Client> in);
}

