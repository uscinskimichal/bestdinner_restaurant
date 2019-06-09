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
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return new ResponseEntity<>( employeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto request) {
        return new ResponseEntity<>(employeeService.create(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity deleteEmployee (@PathVariable("emloyeeId") Integer emloyeeId){
        employeeService.delete(emloyeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee (@PathVariable("employeeId") Integer emloyeeId){
        return new ResponseEntity<>(employeeService.get(emloyeeId), HttpStatus.OK);
    }

    @PutMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                                      @PathVariable("employeeId") Integer employeeId){
        return new ResponseEntity<>(employeeService.update(employeeDto, employeeId), HttpStatus.OK);
    }

}

