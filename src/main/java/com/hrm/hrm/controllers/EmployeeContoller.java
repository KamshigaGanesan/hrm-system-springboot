package com.hrm.hrm.controllers;

import com.hrm.hrm.dtos.requestdtos.EmployeeRequest;
import com.hrm.hrm.services.EmailService;
import com.hrm.hrm.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")

@CrossOrigin
public class EmployeeContoller {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

    @PostMapping(value= "/employee-title")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        if(employeeService.employeeExistsByName(employeeRequest.getNic())){
            return ResponseEntity.ok("NIC already Exists.");
        }
        if(employeeService.employeeExistsByEmail(employeeRequest.getEmail())){
            return ResponseEntity.ok("Email already Exists.");
        }
        employeeService.createEmployee(employeeRequest);
        try {
            emailService.sendEmployeeEmail(employeeRequest.getEmail(), employeeRequest.getName());
            System.out.println("Mail Sent...");
        }catch (Exception e){
            System.out.println("Mail not Sent");
        }
        return ResponseEntity.ok("Employee Created Successfully");


    }

    @PutMapping(value="/employee-title")
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        if(!employeeService.checkEmployeeExists(employeeRequest.getId())){
            return ResponseEntity.ok("Job Not Found");
        }
        if(employeeService.employeeExistsByNameandId(employeeRequest.getNic(),employeeRequest.getId())){
            return ResponseEntity.ok("NIC already exists.");
        }

        if(employeeService.employeeExistsByEmialandId(employeeRequest.getEmail(),employeeRequest.getId())){
            return ResponseEntity.ok("Email is already Exists.");
        }
        employeeService.updateEmployee(employeeRequest);
        return ResponseEntity.ok("Employee Updated Successfully");
    }

    @DeleteMapping(value="/employee-title/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id){
        if(!employeeService.checkEmployeeExists(id)){
            return ResponseEntity.ok("Employee Not Found");
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }

    @GetMapping(value="/employee-title/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id){
        if(!employeeService.checkEmployeeExists(id)){
            return ResponseEntity.ok("Employee Not Found");
        }
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping(value = "/employee-title")
    public ResponseEntity<Object> getEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
