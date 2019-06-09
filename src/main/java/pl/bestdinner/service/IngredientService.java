package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.IngredientDto;
import pl.bestdinner.mapper.IngredientMapper;
import pl.bestdinner.model.Ingredient;
import pl.bestdinner.repositories.IngredientRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }


    @Transactional
    public List<IngredientDto> getAll() {
        return ingredientMapper.convert(ingredientRepository.findAll());
    }

    @Transactional
    public IngredientDto create(IngredientDto in) {
        Ingredient ingredient = ingredientMapper.convert(in);
        ingredient.setIngredientId(0);
        ingredientRepository.save(ingredient);
        return ingredientMapper.convert(ingredient);
    }

    public void delete(Integer ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(NoSuchElementException::new);
        ingredientRepository.delete(ingredient);
    }

    public IngredientDto get(Integer ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(NoSuchElementException::new);
        return ingredientMapper.convert(ingredient);
    }

    public IngredientDto update(IngredientDto ingredientDto, Integer ingredientId) {
        Ingredient ingredient = ingredientMapper.convert(ingredientDto);
        ingredient.setIngredientId(ingredientId);
        ingredientRepository.save(ingredient);
        return ingredientMapper.convert(ingredientRepository.findById(ingredientId).orElseThrow(NoSuchElementException::new));
    }

    
}
