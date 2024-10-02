package com.microservice.department_service.services;


import com.microservice.department_service.dto.DepartmentDto;


public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto searchDepartmentByCode(int code);
}
