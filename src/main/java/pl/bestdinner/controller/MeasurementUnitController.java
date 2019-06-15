package pl.bestdinner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bestdinner.dto.MeasurementUnitDto;
import pl.bestdinner.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementUnitController {

    private final MeasurementService measurementService;

    public MeasurementUnitController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<MeasurementUnitDto>> getAll(){
        return new ResponseEntity<>(measurementService.getAll(), HttpStatus.OK);
    }

}
