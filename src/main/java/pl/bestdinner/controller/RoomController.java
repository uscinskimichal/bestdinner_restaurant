package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.RoomDto;
import pl.bestdinner.service.RoomService;

import java.util.List;

@RestController()
@RequestMapping("/rooms")// nie ma potrzebny dawać  przy każdej metodzie tej samej częsści URL, tworzymy hierarchię zasobów
public class RoomController {


    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }


    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<RoomDto>> getAll() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<RoomDto> create(@RequestBody RoomDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer roomId){
        service.delete(roomId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomDto> get(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoomDto> update(@RequestBody RoomDto requestBody,
                                           @PathVariable("id") Integer id){
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }


}
