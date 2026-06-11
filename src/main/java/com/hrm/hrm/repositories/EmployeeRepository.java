package com.hrm.hrm.repositories;

import com.hrm.hrm.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     boolean existsByNic(String nic);
     boolean existsByNicAndIdNot(String nic,Long id);
     boolean existsByEmail(String email);
     boolean existsByEmailAndIdNot(String email, Long id);
}
