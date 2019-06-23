package pl.bestdinner.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.WarehouseOrderDto;
import pl.bestdinner.mapper.WarehouseOrderMapper;
import pl.bestdinner.model.WarehouseOrder;
import pl.bestdinner.repositories.WarehouseOrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WarehouseOrderService {
    private final WarehouseOrderRepository warehouseOrderRepository;
    private final WarehouseOrderMapper warehouseOrderMapper;

    public WarehouseOrderService(WarehouseOrderRepository warehouseOrderRepository, WarehouseOrderMapper warehouseOrderMapper) {
        this.warehouseOrderRepository = warehouseOrderRepository;
        this.warehouseOrderMapper = warehouseOrderMapper;
    }


    public List<WarehouseOrderDto> getAll(Integer paramEmployeeId, LocalDateTime paramDateFrom, LocalDateTime paramDateTo) {
        return warehouseOrderMapper.convert(warehouseOrderRepository.findAllWithParameters(paramEmployeeId, paramDateFrom, paramDateTo));
    }

    @Transactional
    public WarehouseOrderDto create(WarehouseOrderDto in) {
        WarehouseOrder warehouseOrder = warehouseOrderMapper.convert(in);
        warehouseOrder.setWarehouseOrderId(0L);
        warehouseOrder.getWarehouseOrderItem().forEach(a -> a.setWarehouseOrder(warehouseOrder));
        WarehouseOrder returnedWarehouseOrder = warehouseOrderRepository.save(warehouseOrder);
        return warehouseOrderMapper.convert(returnedWarehouseOrder);
    }

    public void delete(Long warehouseOrderId) {
        WarehouseOrder warehouseOrder = warehouseOrderRepository.findById(warehouseOrderId).orElseThrow(NoSuchElementException::new);
        warehouseOrderRepository.delete(warehouseOrder);
    }

    public WarehouseOrderDto get(Long warehouseOrderId) {
        WarehouseOrder warehouseOrder = warehouseOrderRepository.findById(warehouseOrderId).orElseThrow(NoSuchElementException::new);
        return warehouseOrderMapper.convert(warehouseOrder);
    }

    public WarehouseOrderDto update(WarehouseOrderDto warehouseOrderDto, Long warehouseOrderId) {
        WarehouseOrder warehouseOrder = warehouseOrderMapper.convert(warehouseOrderDto);
        warehouseOrder.setWarehouseOrderId(warehouseOrderId);
        warehouseOrderRepository.save(warehouseOrder);
        return warehouseOrderMapper.convert(warehouseOrderRepository.findById(warehouseOrderId).orElseThrow(NoSuchElementException::new));
    }


}
