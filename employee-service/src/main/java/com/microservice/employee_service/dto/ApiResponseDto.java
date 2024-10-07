package com.microservice.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponseDto {
    private  EmployeeDTO employeeDTO;
    private  DepartmentDto departmentDto;
}
