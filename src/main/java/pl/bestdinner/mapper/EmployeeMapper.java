package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.EmployeeDto;
import pl.bestdinner.model.Employee;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto convert(Employee in);
    List<EmployeeDto> convert(List<Employee> in);
    Employee convert(EmployeeDto in);
}
