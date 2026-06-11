package com.hrm.hrm.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    private String email;
    private int age;
    private String nic;

    @OneToOne
    @JoinColumn(name="job_id",nullable = false)
    private Job job;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projectList;

    @ManyToMany
    @JoinTable(name="employee_roles", joinColumns = @JoinColumn(name="employee_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> rolesList= new HashSet<>();
}
