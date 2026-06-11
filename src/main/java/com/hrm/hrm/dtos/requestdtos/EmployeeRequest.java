package com.hrm.hrm.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class EmployeeRequest {
    private Long id;
    private String name;
    private String address;
    private String email;
    private int age;
    private String nic;
    private Long jobId;

    private Set<Long> roleIds;
}
