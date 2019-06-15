package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.AddressClientDto;
import pl.bestdinner.dto.ClientDto;
import pl.bestdinner.service.ClientService;

import java.util.List;

@RestController()
@RequestMapping("/clients")// nie ma potrzebny dawać  przy każdej metodzie tej samej częsści URL, tworzymy hierarchię zasobów
public class ClientController {


    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    /*@GetMapping(value = "/tst", produces = "application/json;charset=UTF-8")
    public ResponseEntity<AddressClientDto> test() {
        return new ResponseEntity<>(AddressClientDto.builder()
                .addressId(1L)
                .apartmentNumber("aaaa")
                .city("bbbbb")
                .streetNumber("12")
                .build(), HttpStatus.OK);
    }*/


    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<ClientDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long clientId){
        service.delete(clientId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto requestBody,
                                                  @PathVariable("id") Long id){
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }


}
