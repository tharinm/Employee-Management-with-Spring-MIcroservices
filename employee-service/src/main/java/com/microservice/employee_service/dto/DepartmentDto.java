package com.microservice.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDto {

    private int id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
