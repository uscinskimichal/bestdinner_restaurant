package pl.bestdinner.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.DishDto;
import pl.bestdinner.service.DishService;

import java.util.List;

@RestController()
@RequestMapping("/dishes")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<DishDto>> getAll() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<DishDto> create(@RequestBody DishDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DishDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<DishDto> update(@RequestBody DishDto requestBody,
                                            @PathVariable("id") Long id){
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }
}
