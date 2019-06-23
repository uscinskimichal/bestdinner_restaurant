package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.TableDto;
import pl.bestdinner.mapper.TableMapper;
import pl.bestdinner.model.Table;
import pl.bestdinner.repositories.TableRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TableService {

    private final TableRepository tableRepository;
    private final TableMapper tableMapper;

    public TableService(TableRepository tableRepository, TableMapper tableMapper) {
        this.tableRepository = tableRepository;
        this.tableMapper = tableMapper;
    }

    @Transactional
    public List<TableDto> getAll() {
        return tableMapper.convert(tableRepository.findAll());
    }

    @Transactional
    public TableDto create(TableDto in) {
        Table table = tableMapper.convert(in);
        table.setTableId(0L);
        Table returnedTable = tableRepository.save(table);
        return tableMapper.convert(returnedTable);
    }

    @Transactional
    public void delete(Long tableId) {
        Table table = tableRepository.findById(tableId).orElseThrow(NoSuchElementException::new);
        tableRepository.delete(table);
    }

    @Transactional
    public TableDto get(Long tableId) {
        Table table = tableRepository.findById(tableId).orElseThrow(NoSuchElementException::new);
        return tableMapper.convert(table);
    }

    @Transactional
    public TableDto update(TableDto tableDto, Long tableId) {
        Table table = tableMapper.convert(tableDto);
        table.setTableId(tableId);
        tableRepository.save(table);
        return tableMapper.convert(tableRepository.findById(tableId).orElseThrow(NoSuchElementException::new));
    }
}
