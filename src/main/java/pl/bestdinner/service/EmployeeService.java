package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.EmployeeDto;
import pl.bestdinner.mapper.EmployeeMapper;
import pl.bestdinner.model.Employee;
import pl.bestdinner.repositories.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    @Transactional
    public List<EmployeeDto> getAll() {
        return employeeMapper.convert(employeeRepository.findAll());
    }

    @Transactional
    public EmployeeDto create(EmployeeDto in) {
        Employee employee = employeeMapper.convert(in);
        employee.setIdEmployee(0);
        employeeRepository.save(employee);
        return employeeMapper.convert(employee);
    }

    public void delete(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        employeeRepository.delete(employee);
    }

    public EmployeeDto get(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        return employeeMapper.convert(employee);
    }

    public EmployeeDto update(EmployeeDto clientDto, Integer employeeId) {
        Employee employee = employeeMapper.convert(clientDto);
        employee.setIdEmployee(employeeId);
        employeeRepository.save(employee);
        return employeeMapper.convert(employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new));
    }
}
