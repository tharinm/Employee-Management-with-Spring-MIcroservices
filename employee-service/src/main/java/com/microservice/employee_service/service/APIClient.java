package com.microservice.employee_service.service;


import com.microservice.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(url="http://localhost:8080" ,value="DEPARTMENT-SERVICE")
@FeignClient(name="department-service")
public interface APIClient {


    @GetMapping("api/department/get-department-by-code")
    DepartmentDto getDepartment(@RequestParam(value="code") String code);

}
