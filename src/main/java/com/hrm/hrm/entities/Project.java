package com.hrm.hrm.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Project {
    @Id

    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;


}
