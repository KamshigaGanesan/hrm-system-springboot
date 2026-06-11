package com.hrm.hrm.services;

import com.hrm.hrm.dtos.requestdtos.EmployeeRequest;
import com.hrm.hrm.dtos.responsedtos.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeRequest employeeRequest);
    void updateEmployee(EmployeeRequest employeeRequest);
    boolean checkEmployeeExists(Long id);
    void deleteEmployee(Long id);
    EmployeeResponse getEmployee(Long id);
    List<EmployeeResponse> getEmployees();
    boolean employeeExistsByName(String nic);
    boolean employeeExistsByNameandId(String nic,Long id);
    boolean employeeExistsByEmail(String email);
    boolean employeeExistsByEmialandId(String email,Long id);
}
