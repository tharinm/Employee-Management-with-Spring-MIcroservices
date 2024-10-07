package com.microservice.department_service.services.impl;

import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.entity.Department;
import com.microservice.department_service.repository.DepartmentRepository;
import com.microservice.department_service.services.DepartmentService;
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
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department=modelMapper.map(departmentDto ,Department.class);
        departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = modelMapper.map(department, DepartmentDto.class);
        return savedDepartmentDto;

    }

    @Override
    public DepartmentDto searchDepartmentByCode(String code) {

        Department department=departmentRepository.findByDepartmentCode(code);

        DepartmentDto departmentDto=modelMapper.map(department,DepartmentDto.class);
        return  departmentDto;
    }


}
