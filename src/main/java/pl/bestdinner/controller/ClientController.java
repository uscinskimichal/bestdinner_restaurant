package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.ClientDto;
import pl.bestdinner.service.ClientService;

import java.util.List;

@RestController("/clients") // nie ma potrzebny dawać  przy każdej metodzie tej samej częsści URL, tworzymy hierarchię zasobów
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<ClientDto>> getClients() {
        return new ResponseEntity<>( clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto request) {
        return new ResponseEntity<>(clientService.create(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clientId}")
    public ResponseEntity deleteClient (@PathVariable("clientId") Integer clientId){
        clientService.delete(clientId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{clientId}")
    public ResponseEntity<ClientDto> getClient (@PathVariable("clientId") Integer clientId){
        return new ResponseEntity<>(clientService.get(clientId), HttpStatus.OK);
    }

    @PutMapping(value = "/{clientId}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto,
                                                  @PathVariable("clientId") Integer clientId){
        return new ResponseEntity<ClientDto>(clientService.update(clientDto, clientId), HttpStatus.OK);
    }



//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Object getKlient(@PathVariable("id") int id) {
//        return clientRepository.findClient(id);
//    }
//

}
