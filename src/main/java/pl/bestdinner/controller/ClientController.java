package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.ClientDto;
import pl.bestdinner.service.ClientService;

import java.util.List;

@Controller("/clients") // nie ma potrzebny dawać  przy każdej metodzie tej samej częsści URL, tworzymy hierarchię zasobów
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<ClientDto>> getClients() {
        List<ClientDto> clientDtos = clientService.getClients();
        clientDtos.forEach(System.out::println);
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Object getKlient(@PathVariable("id") int id) {
//        return clientRepository.findClient(id);
//    }
//

}
