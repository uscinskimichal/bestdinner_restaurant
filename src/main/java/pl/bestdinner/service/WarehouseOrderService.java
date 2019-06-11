package pl.bestdinner.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.WarehouseOrderDto;
import pl.bestdinner.mapper.WarehouseOrderMapper;
import pl.bestdinner.model.WarehouseOrder;
import pl.bestdinner.repositories.WarehouseOrderRepository;

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


    @Transactional
    public List<WarehouseOrderDto> getAll() {
        return warehouseOrderMapper.convert(warehouseOrderRepository.findAll());
    }

    @Transactional
    public WarehouseOrderDto create(WarehouseOrderDto in) {
        WarehouseOrder warehouseOrder = warehouseOrderMapper.convert(in);
        warehouseOrder.setWarehouseOrderId(0);
        warehouseOrderRepository.save(warehouseOrder);
        return warehouseOrderMapper.convert(warehouseOrder);
    }

    public void delete(Integer warehouseOrderId) {
        WarehouseOrder warehouseOrder = warehouseOrderRepository.findById(warehouseOrderId).orElseThrow(NoSuchElementException::new);
        warehouseOrderRepository.delete(warehouseOrder);
    }

    public WarehouseOrderDto get(Integer warehouseOrderId) {
        WarehouseOrder warehouseOrder = warehouseOrderRepository.findById(warehouseOrderId).orElseThrow(NoSuchElementException::new);
        return warehouseOrderMapper.convert(warehouseOrder);
    }

    public WarehouseOrderDto update(WarehouseOrderDto warehouseOrderDto, Integer warehouseOrderId) {
        WarehouseOrder warehouseOrder = warehouseOrderMapper.convert(warehouseOrderDto);
        warehouseOrder.setWarehouseOrderId(warehouseOrderId);
        warehouseOrderRepository.save(warehouseOrder);
        return warehouseOrderMapper.convert(warehouseOrderRepository.findById(warehouseOrderId).orElseThrow(NoSuchElementException::new));
    }


}
