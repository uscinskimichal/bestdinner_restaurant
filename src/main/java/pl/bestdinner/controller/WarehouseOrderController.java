package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.WarehouseOrderDto;
import pl.bestdinner.service.WarehouseOrderService;

import java.util.List;

@RestController()
@RequestMapping("/warehouseOrders")// nie ma potrzebny dawać  przy każdej metodzie tej samej częsści URL, tworzymy hierarchię zasobów
public class WarehouseOrderController {


    private final WarehouseOrderService service;

    public WarehouseOrderController(WarehouseOrderService service) {
        this.service = service;
    }


    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<WarehouseOrderDto>> getAll() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<WarehouseOrderDto> create(@RequestBody WarehouseOrderDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long warehouseOrderId){
        service.delete(warehouseOrderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WarehouseOrderDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<WarehouseOrderDto> update(@RequestBody WarehouseOrderDto requestBody,
                                          @PathVariable("id") Long id){
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }


}
