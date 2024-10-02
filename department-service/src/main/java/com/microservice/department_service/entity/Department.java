package com.microservice.department_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="department")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name="department_name",length = 225)
        private String departmentName;

        @Column(name="departmentDesc",length = 225)
        private String departmentDescription;

        @Column(name="departmentCode",length = 225,unique = true)
        private String departmentCode;
}
