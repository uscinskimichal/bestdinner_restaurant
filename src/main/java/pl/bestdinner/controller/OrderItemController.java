package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.OrderItemDto;
import pl.bestdinner.service.OrderItemService;

import java.util.List;

@RestController()
@RequestMapping("/order_items")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json;charset=UTF-8") // można dorzucić  produces, żeby jawnie ustawić kodowanie
    public ResponseEntity<List<OrderItemDto>> getAll() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<OrderItemDto> create(@RequestBody OrderItemDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItemDto> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<OrderItemDto> update(@RequestBody OrderItemDto requestBody,
                                                @PathVariable("id") Long id){
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }
}
