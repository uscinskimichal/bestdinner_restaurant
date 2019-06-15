package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import pl.bestdinner.dto.MeasurementUnitDto;
import pl.bestdinner.mapper.MeasurementMapper;
import pl.bestdinner.repositories.MeasurementRepository;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    public MeasurementService(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper) {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
    }

    public List<MeasurementUnitDto> getAll(){
        return measurementMapper.convert(measurementRepository.findAll());
    }
}
