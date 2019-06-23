package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.DishTypeDto;
import pl.bestdinner.mapper.DishTypeMapper;
import pl.bestdinner.model.DishType;
import pl.bestdinner.repositories.DishTypeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DishTypeService {
    private final DishTypeRepository dishTypeRepository;
    private final DishTypeMapper dishTypeMapper;

    public DishTypeService(DishTypeRepository dishTypeRepository, DishTypeMapper dishTypeMapper) {
        this.dishTypeRepository = dishTypeRepository;
        this.dishTypeMapper = dishTypeMapper;
    }

    @Transactional
    public List<DishTypeDto> getAll() {
        return dishTypeMapper.convert(dishTypeRepository.findAll());
    }

    public DishTypeDto get(Long dishId) {
        DishType dishType = dishTypeRepository.findById(dishId).orElseThrow(NoSuchElementException::new);
        return dishTypeMapper.convert(dishType);
    }
}
