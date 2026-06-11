package com.hrm.hrm.services;

import com.hrm.hrm.dtos.requestdtos.RoleRequest;
import com.hrm.hrm.dtos.responsedtos.ProjectResponse;
import com.hrm.hrm.dtos.responsedtos.RoleResponse;

import java.util.List;

public interface RoleService {
    void createRole(RoleRequest roleRequest);
    void updateRole(RoleRequest roleRequest);
    boolean checkRoleExists(Long id);
    void deleteRole(Long id);
    RoleResponse getRole(Long id);
    List<RoleResponse> getRoles();
}
