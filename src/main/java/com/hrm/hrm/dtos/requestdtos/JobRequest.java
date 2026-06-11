package com.hrm.hrm.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequest {
    private Long id;
    private String name;
    private String description;
}
