package com.microservice.department_service.services;


import com.microservice.department_service.dto.DepartmentDto;
import org.springframework.stereotype.Service;


public interface DepartmentService {
    String saveDepartment(DepartmentDto departmentDto);
}
