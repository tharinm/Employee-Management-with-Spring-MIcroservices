package com.microservice.employee_service.service.impl;

import com.microservice.employee_service.dto.ApiResponseDto;
import com.microservice.employee_service.dto.DepartmentDto;
import com.microservice.employee_service.dto.EmployeeDTO;
import com.microservice.employee_service.entity.Employee;
import com.microservice.employee_service.repository.EmployeeRepo;
import com.microservice.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class employeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

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
    public ApiResponseDto getEmployeeById(int id) {

        if(employeeRepo.existsById(id)) {
            Employee employee = employeeRepo.getReferenceById(id);
            System.out.println("Employee Department Code: " + employee.getDepartmentCode());

            ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/department/get-department-by-code?code=" + employee.getDepartmentCode(), DepartmentDto.class);

            System.out.println("Response Body: " + responseEntity.getBody());


            DepartmentDto departmentDto=responseEntity.getBody();

            EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
//            DepartmentDto departmentDto1=modelMapper.map()
            ApiResponseDto apiResponseDto=new ApiResponseDto();
            apiResponseDto.setEmployeeDTO(employeeDTO);
            apiResponseDto.setDepartmentDto(departmentDto);

            return apiResponseDto;
        }
        else{
            throw new RuntimeException("no register employee");
        }
    }
}
