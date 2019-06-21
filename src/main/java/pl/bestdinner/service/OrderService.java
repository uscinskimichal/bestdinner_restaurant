package pl.bestdinner.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bestdinner.dto.OrderDto;
import pl.bestdinner.mapper.OrderMapper;
import pl.bestdinner.model.Order;
import pl.bestdinner.repositories.OrderRepository;

import java.sql.Date;
import java.time.LocalDateTime;
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

    public List<OrderDto> getAll(String paramStatus,
                                  Integer paramClientId ,
                                  Integer paramEmployeeId,
                                  LocalDateTime paramDateFrom,
                                  LocalDateTime paramDateTo,
                                  String paramType){
        return orderMapper.convert(orderRepository.findAllWithParameters(paramStatus, paramClientId , paramEmployeeId, paramDateFrom, paramDateTo, paramType));
    }

    @Transactional
    public OrderDto create(OrderDto in) {
        Order order = orderMapper.convert(in);
        order.setOrderId(0L);
        orderRepository.save(order);
        return orderMapper.convert(order);
    }

    public void delete(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        orderRepository.delete(order);
    }

    public OrderDto get(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        return orderMapper.convert(order);
    }

    public OrderDto update(OrderDto orderDto, Long orderId) {
        Order order = orderMapper.convert(orderDto);
        order.setOrderId(orderId);
        orderRepository.save(order);
        return orderMapper.convert(orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new));
    }


}
