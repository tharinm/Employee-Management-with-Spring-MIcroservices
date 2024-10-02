package com.microservice.department_service.services.impl;

import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.entity.Department;
import com.microservice.department_service.repository.DepartmentRepository;
import com.microservice.department_service.services.DepartmentService;
import com.microservice.department_service.utils.DepartmentMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveDepartment(DepartmentDto departmentDto) {

        Department department=DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment=departmentRepository.save(department);

        return "";
    }

    @Override
    public DepartmentDto searchDepartmentByCode(int code) {

        Department department=departmentRepository.getReferenceById(code);

        DepartmentDto departmentDto=modelMapper.map(department,DepartmentDto.class);
        return  departmentDto;
    }


}
