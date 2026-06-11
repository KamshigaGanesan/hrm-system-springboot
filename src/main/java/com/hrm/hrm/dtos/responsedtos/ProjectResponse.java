package com.hrm.hrm.dtos.responsedtos;

import com.hrm.hrm.entities.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponse {
    private Long id;
    private String name;
    private Long employeeId;
}
