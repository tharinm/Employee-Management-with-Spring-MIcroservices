package com.microservice.department_service.controllert;


import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.services.DepartmentService;
import com.microservice.department_service.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto message=departmentService.saveDepartment(departmentDto);
        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(new StandardResponse(201,"success",message), HttpStatus.CREATED);
        return  response;

    }


    @GetMapping(path="/get-department-by-code",params = {"code"})
    public ResponseEntity<StandardResponse> getDepartmentByCode(@RequestParam(value="code") int code){

        DepartmentDto message=departmentService.searchDepartmentByCode(code);
        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(new StandardResponse(201,"success",message), HttpStatus.CREATED);
        return  response;

    }


}
