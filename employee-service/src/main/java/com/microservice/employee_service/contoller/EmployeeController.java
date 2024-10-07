package com.microservice.employee_service.contoller;


import com.microservice.employee_service.dto.ApiResponseDto;
import com.microservice.employee_service.dto.EmployeeDTO;
import com.microservice.employee_service.service.EmployeeService;
import com.microservice.employee_service.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse>saveEmploye(@RequestBody EmployeeDTO employeeDTO){
        String message= employeeService.saveEmployeeService(employeeDTO);
        ResponseEntity<StandardResponse> response= new ResponseEntity<StandardResponse>(new StandardResponse(201,"success",message), HttpStatus.CREATED);
        return  response;
    }

    @GetMapping(value = "/get-emp-by-id",params = {"id"})
    public ResponseEntity<StandardResponse> getEmployee(@RequestParam(value = "id") int id)
    {
        ApiResponseDto apiResponseDto=employeeService.getEmployeeById(id);

        ResponseEntity<StandardResponse> response= new ResponseEntity<StandardResponse>(new StandardResponse(201,"success",apiResponseDto), HttpStatus.CREATED);
        return response;
    }

}
