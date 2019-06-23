package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bestdinner.dto.StatusDto;
import pl.bestdinner.service.StatusService;

import java.util.List;

@RestController()
@RequestMapping("/status")
public class StatusController {
    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<StatusDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StatusDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
}
