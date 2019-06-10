package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.EmployeeOrderDto;
import pl.bestdinner.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeOrderMapper {
    EmployeeOrderDto convert(Employee in);
    Employee convert(EmployeeOrderDto in);
}
