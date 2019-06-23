package pl.bestdinner.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bestdinner.dto.DishTypeDto;
import pl.bestdinner.service.DishTypeService;

import java.util.List;

@RestController()
@RequestMapping("/types")
public class DishTypeController {

    private final DishTypeService service;

    public DishTypeController(DishTypeService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<DishTypeDto>> getAll() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DishTypeDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
}
