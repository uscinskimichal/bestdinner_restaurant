package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.IngredientDto;
import pl.bestdinner.dto.EmployeeDto;
import pl.bestdinner.dto.IngredientDto;
import pl.bestdinner.service.EmployeeService;
import pl.bestdinner.service.IngredientService;

import java.util.List;

@RestController()
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<IngredientDto>> getAll() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<IngredientDto> create(@RequestBody IngredientDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IngredientDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<IngredientDto> update(@RequestBody IngredientDto requestBody,
                                                  @PathVariable("id") Long id){
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }
}
