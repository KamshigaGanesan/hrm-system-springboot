package com.hrm.hrm.dtos.requestdtos;


import com.hrm.hrm.entities.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {
    private Long id;
    private String name;
    private Long employeeId;
}
