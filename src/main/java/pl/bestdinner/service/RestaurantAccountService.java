package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import pl.bestdinner.dto.RestaurantAccountDto;
import pl.bestdinner.mapper.RestaurantAccountMapper;
import pl.bestdinner.model.RestaurantAccount;
import pl.bestdinner.repositories.RestaurantAccountRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestaurantAccountService {
    private final RestaurantAccountRepository restaurantAccountRepository;
    private final RestaurantAccountMapper restaurantAccountMapper;

    public RestaurantAccountService(RestaurantAccountRepository restaurantAccountRepository, RestaurantAccountMapper restaurantAccountMapper) {
        this.restaurantAccountRepository = restaurantAccountRepository;
        this.restaurantAccountMapper = restaurantAccountMapper;
    }

    public List<RestaurantAccountDto> getAll() {
        return restaurantAccountMapper.convert(restaurantAccountRepository.findAll());

    }

    public RestaurantAccountDto get(Long restaurantId) {
        return restaurantAccountMapper.convert(restaurantAccountRepository.findById(restaurantId).orElseThrow(NoSuchElementException::new));
    }

    public RestaurantAccountDto update(RestaurantAccountDto restaurantAccountDto, Long restaurantId) {
        RestaurantAccount restaurantAccount = restaurantAccountMapper.convert(restaurantAccountDto);
        restaurantAccount.setIdRestaurant(restaurantId);
        restaurantAccountRepository.save(restaurantAccount);
        return restaurantAccountMapper.convert(restaurantAccountRepository.findById(restaurantId).orElseThrow(NoSuchElementException::new));
    }

    public RestaurantAccountDto updateBalance(Long restaurantId, Double change) {
        RestaurantAccount restaurantAccount = restaurantAccountRepository.findById(restaurantId).orElseThrow(NoSuchElementException::new);
        restaurantAccount.setBalance(restaurantAccount.getBalance().add(BigDecimal.valueOf(change)));
        restaurantAccountRepository.save(restaurantAccount);
        return restaurantAccountMapper.convert(restaurantAccountRepository.findById(restaurantId).orElseThrow(NoSuchElementException::new));
    }
}
