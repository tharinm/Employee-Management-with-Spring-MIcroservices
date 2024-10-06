package com.microservice.employee_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;


    @Column(name="emp_first_name",length = 225)
    private String firstName;

    @Column(name="emp_last_name",length = 225)
    private String lastName;

    @Column(name="emp_email",length = 225,nullable = false,unique = true)
    private String email;


}
