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



    public List<OrderDto> getAll(String status, String clientId, String employeeId, Date dateFrom, Date dateTo, String type) {
        if(status!=null) return orderMapper.convert(orderRepository.findAllByStatus(status));
        else if(type!=null) return orderMapper.convert(orderRepository.findAllByType(type));
        else if(dateFrom!=null) return orderMapper.convert(orderRepository.findAllByDateGreaterThanEqual(dateFrom));
        else if(dateTo!=null) return orderMapper.convert(orderRepository.findAllByDateIsLessThanEqual(dateTo));
        else if(clientId!=null) return orderMapper.convert(orderRepository.findAllByClients(Integer.parseInt(clientId)));
        else if(employeeId!=null) return orderMapper.convert(orderRepository.findAllByEmployee(Integer.parseInt(employeeId)));
        return  orderMapper.convert(orderRepository.findAll());
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
