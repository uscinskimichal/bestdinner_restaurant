package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.RestaurantAccountDto;
import pl.bestdinner.service.RestaurantAccountService;

import java.util.List;


@RestController()
@RequestMapping("/restaurants")
public class RestaurantAccountController {

    private final RestaurantAccountService service;

    public RestaurantAccountController(RestaurantAccountService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<RestaurantAccountDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<RestaurantAccountDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<RestaurantAccountDto> update(@RequestBody RestaurantAccountDto requestBody,
                                                       @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.update(requestBody, id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8", params = "change")
    public ResponseEntity<RestaurantAccountDto> updateBalance(
            @PathVariable("id") Long id,
            @RequestParam(value = "change") Double change) {
        return new ResponseEntity<>(service.updateBalance(id, change), HttpStatus.OK);
    }

}
