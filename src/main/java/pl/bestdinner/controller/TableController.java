package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.dto.TableDto;
import pl.bestdinner.service.TableService;

import java.util.List;

@RestController()
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<TableDto>> getAll() {
        return new ResponseEntity<>(tableService.getAll(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<TableDto> create(@RequestBody TableDto tableDto) {
        return new ResponseEntity<>(tableService.create(tableDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        tableService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TableDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tableService.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TableDto> update(@RequestBody TableDto tableDto, @PathVariable("id") Long id) {
        return new ResponseEntity<>(tableService.update(tableDto, id), HttpStatus.OK);
    }
}
