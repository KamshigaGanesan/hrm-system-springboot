package com.hrm.hrm.controllers;

import com.hrm.hrm.dtos.requestdtos.RoleRequest;
import com.hrm.hrm.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")

@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value="/role-title")
    public ResponseEntity<Object> createRole(@RequestBody RoleRequest roleRequest){
        roleService.createRole(roleRequest);
        return ResponseEntity.ok("Role Successfully Created.");
    }

    @PutMapping(value="/role-title")
    public ResponseEntity<Object> updateRole(@RequestBody RoleRequest roleRequest){
        roleService.updateRole(roleRequest);
        return  ResponseEntity.ok("Role Updated Successfull.");
    }

    @DeleteMapping("/role-title/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id){
        if(!roleService.checkRoleExists(id)){
            return ResponseEntity.ok("Role Not Found");
        }
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role Deleted Successfully");
    }

    @GetMapping("/role-title/{id}")
    public ResponseEntity<Object> GetRole(@PathVariable Long id) {
        if (!roleService.checkRoleExists(id)) {
            return ResponseEntity.ok("Role Not Found");
        }
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @GetMapping("/role-title")
    public ResponseEntity<Object> getRoles(){

        return ResponseEntity.ok(roleService.getRoles());
    }
}
