package pl.bestdinner.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.ClientDto;
import pl.bestdinner.mapper.ClientMapper;
import pl.bestdinner.model.Client;
import pl.bestdinner.repositories.ClientRepository;

import java.util.List;
import java.util.NoSuchElementException;

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


    @Transactional
    public List<ClientDto> getAll() {
        return clientMapper.convert(clientRepository.findAll());
    }

    @Transactional
    public ClientDto create(ClientDto in) {
        Client client = clientMapper.convert(in);
        client.setIdClient(0L);
        Client returnedClient = clientRepository.save(client);
        return clientMapper.convert(returnedClient);
    }

    public void delete(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(NoSuchElementException::new);
        clientRepository.delete(client);
    }

    public ClientDto get(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(NoSuchElementException::new);
        return clientMapper.convert(client);
    }

    public ClientDto get(String login, String password) {
        Client client = clientRepository.findByLoginEqualsAndPasswordEquals(login,password);
        return clientMapper.convert(client);
    }

    public ClientDto update(ClientDto clientDto, Long clientId) {
        Client client = clientMapper.convert(clientDto);
        client.setIdClient(clientId);
        clientRepository.save(client);
        return clientMapper.convert(clientRepository.findById(clientId).orElseThrow(NoSuchElementException::new));
    }
}
