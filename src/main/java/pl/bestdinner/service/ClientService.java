package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import pl.bestdinner.dto.ClientDto;
import pl.bestdinner.mapper.ClientMapper;
import pl.bestdinner.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    /* Wstrzyknięcia przez konstruktor są zalecane przez twórców Springa
    * Trzeba bardzo uważać z innymi */
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }


    public List<ClientDto> getClients() {
        return clientMapper.convert(clientRepository.findAll());
    }
}
