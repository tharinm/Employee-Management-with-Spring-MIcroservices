package com.microservice.employee_service.service;

import com.microservice.employee_service.dto.EmployeeDTO;

public interface EmployeeService {


    String saveEmployeeService(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(int id);
}
