package com.hrm.hrm.repositories;

import com.hrm.hrm.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
