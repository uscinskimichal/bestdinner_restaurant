package pl.bestdinner.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.OrderDto;
import pl.bestdinner.mapper.OrderMapper;
import pl.bestdinner.model.Order;
import pl.bestdinner.repositories.OrderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Transactional
    public List<OrderDto> getAll() {
        return orderMapper.convert(orderRepository.findAll());
    }

    @Transactional
    public OrderDto create(OrderDto in) {
        Order order = orderMapper.convert(in);
        order.setOrderId(0);
        orderRepository.save(order);
        return orderMapper.convert(order);
    }

    public void delete(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        orderRepository.delete(order);
    }

    public OrderDto get(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        return orderMapper.convert(order);
    }

    public OrderDto update(OrderDto orderDto, Integer orderId) {
        Order order = orderMapper.convert(orderDto);
        order.setOrderId(orderId);
        orderRepository.save(order);
        return orderMapper.convert(orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new));
    }


}
