package com.hrm.hrm.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

    @ManyToMany(mappedBy = "rolesList")
    private Set<Employee> employees=new HashSet<>();

}
