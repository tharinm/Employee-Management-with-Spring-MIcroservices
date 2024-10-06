package com.microservice.employee_service.service.impl;

import com.microservice.employee_service.dto.EmployeeDTO;
import com.microservice.employee_service.entity.Employee;
import com.microservice.employee_service.repository.EmployeeRepo;
import com.microservice.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class employeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public String saveEmployeeService(EmployeeDTO employeeDTO) {
        Employee employee=modelMapper.map(employeeDTO ,Employee.class);

        if(!employeeRepo.existsById(employee.getEmpId())){
            employeeRepo.save(employee);
            EmployeeDTO savedEmployeeDto=modelMapper.map(employee,EmployeeDTO.class);
            return "saved Employee";
        }
        else{
                throw  new RuntimeException("Employee already registered");
        }


    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {

        if(employeeRepo.existsById(id)) {
            Employee employee = employeeRepo.getReferenceById(id);
            EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
            return employeeDTO;
        }
        else{
            throw new RuntimeException("no register employee");
        }
    }
}
