package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.DishDto;
import pl.bestdinner.mapper.DishMapper;
import pl.bestdinner.model.Dish;
import pl.bestdinner.repositories.DishRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public DishService(DishRepository dishRepository, DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }


    @Transactional
    public List<DishDto> getAll() {
        return dishMapper.convert(dishRepository.findAll());
    }

    @Transactional
    public DishDto create(DishDto in) {
        Dish dish = dishMapper.convert(in);
        dish.setIdDish(0L);
        dishRepository.save(dish);
        return dishMapper.convert(dish);
    }

    public void delete(Long dishId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(NoSuchElementException::new);
        dishRepository.delete(dish);
    }

    public DishDto get(Long dishId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(NoSuchElementException::new);
        return dishMapper.convert(dish);
    }

    public DishDto update(DishDto clientDto, Long dishId) {
        Dish dish = dishMapper.convert(clientDto);
        dish.setIdDish(dishId);
        dishRepository.save(dish);
        return dishMapper.convert(dishRepository.findById(dishId).orElseThrow(NoSuchElementException::new));
    }
}
