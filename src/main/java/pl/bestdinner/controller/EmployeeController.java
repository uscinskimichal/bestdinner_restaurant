package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.EmployeeDto;
import pl.bestdinner.service.EmployeeService;

import java.util.List;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return new ResponseEntity<>( employeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto requestBody) {
        return new ResponseEntity<>(employeeService.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto requestBody,
                                                      @PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.update(requestBody, id), HttpStatus.OK);
    }

}

