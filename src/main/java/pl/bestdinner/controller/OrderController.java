package pl.bestdinner.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.OrderDto;
import pl.bestdinner.service.OrderService;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/orders")
// nie ma potrzebny dawać  przy każdej metodzie tej samej częsści URL, tworzymy hierarchię zasobów
public class OrderController {


    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }


    //TODO Co to jest? Skąd dev używający API ma wiedzieć jak to działa?
    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<OrderDto>> findAll(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "clientId", required = false) Integer clientId,
            @RequestParam(value = "employeeId", required = false) Integer employeeId,

            @RequestParam(value = "dateFrom", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,

            @RequestParam(value = "dateTo", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo,

            @RequestParam(value = "type", required = false) String type) {
        return new ResponseEntity<>(service.getAll(status, clientId, employeeId, dateFrom, dateTo, type), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto requestBody) {
        return new ResponseEntity<>(service.create(requestBody), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long orderId) {
        service.delete(orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto requestBody,
                                           @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }


}
