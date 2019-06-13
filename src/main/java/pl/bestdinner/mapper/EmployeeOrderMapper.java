package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.EmployeeOrderDto;
import pl.bestdinner.model.Employee;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeOrderMapper {
    EmployeeOrderDto convert(Employee in);
    List<EmployeeOrderDto> convert(List<Employee> in);
    Employee convert(EmployeeOrderDto in);
}
