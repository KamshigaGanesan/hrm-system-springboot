package com.hrm.hrm.services.serviceIMP;

import com.hrm.hrm.dtos.requestdtos.RoleRequest;
import com.hrm.hrm.dtos.responsedtos.RoleResponse;
import com.hrm.hrm.entities.Role;
import com.hrm.hrm.repositories.RoleRepository;
import com.hrm.hrm.services.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createRole(RoleRequest roleRequest){
        Role role=new Role();
        BeanUtils.copyProperties(roleRequest,role);
        roleRepository.save(role);
    }

    @Override
    public void updateRole(RoleRequest roleRequest){
        Role role=roleRepository.findById(roleRequest.getId()).orElse(null);
        if(role!=null){
            BeanUtils.copyProperties(roleRequest,role);
        }
        roleRepository.save(role);

    }

    @Override
    public boolean checkRoleExists(Long id){
        return roleRepository.existsById(id);
    }

    @Override
    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

    @Override
    public RoleResponse getRole(Long id){
        RoleResponse roleResponse=new RoleResponse();
        Role role=roleRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(role,roleResponse);
        return roleResponse;
    }

    @Override
    public List<RoleResponse> getRoles(){
        List<RoleResponse> roleResponseList =new ArrayList<>();
        List<Role> roleList=roleRepository.findAll();
        for(Role role : roleList){
            RoleResponse roleResponse=new RoleResponse();
            BeanUtils.copyProperties(role,roleResponse);
            roleResponseList.add(roleResponse);
        }
        return roleResponseList;
    }
}
