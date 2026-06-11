package com.hrm.hrm.repositories;

import com.hrm.hrm.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project ,Long> {
}
