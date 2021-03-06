package pl.bestdinner.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.OrderItemDto;
import pl.bestdinner.mapper.OrderItemMapper;
import pl.bestdinner.model.OrderItem;
import pl.bestdinner.repositories.OrderItemRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }


    @Transactional
    public List<OrderItemDto> getAll() {
        return orderItemMapper.convert(orderItemRepository.findAll());
    }

    @Transactional
    public OrderItemDto create(OrderItemDto in) {
        OrderItem orderItem = orderItemMapper.convert(in);
        orderItem.setOrderItemId(0L);
        OrderItem returnedOrderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.convert(returnedOrderItem);
    }

    public void delete(Long orderItemId) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId).orElseThrow(NoSuchElementException::new);
        orderItemRepository.delete(orderItem);
    }

    public OrderItemDto get(Long orderItemId) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId).orElseThrow(NoSuchElementException::new);
        return orderItemMapper.convert(orderItem);
    }

    public OrderItemDto update(OrderItemDto orderItemDto, Long orderItemId) {
        OrderItem orderItem = orderItemMapper.convert(orderItemDto);
        orderItem.setOrder(orderItemRepository.findById(orderItemId).orElseThrow(NoSuchElementException::new).getOrder());
        orderItem.setOrderItemId(orderItemId);
        orderItemRepository.save(orderItem);
        return orderItemMapper.convert(orderItemRepository.findById(orderItemId).orElseThrow(NoSuchElementException::new));
    }


}
