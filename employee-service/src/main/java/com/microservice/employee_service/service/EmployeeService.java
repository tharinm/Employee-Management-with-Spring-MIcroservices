package com.microservice.employee_service.service;

import com.microservice.employee_service.dto.ApiResponseDto;
import com.microservice.employee_service.dto.EmployeeDTO;

public interface EmployeeService {


    String saveEmployeeService(EmployeeDTO employeeDTO);

    ApiResponseDto getEmployeeById(int id);
}
