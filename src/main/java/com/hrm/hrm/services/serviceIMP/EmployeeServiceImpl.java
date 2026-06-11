package com.hrm.hrm.services.serviceIMP;

import com.hrm.hrm.dtos.requestdtos.EmployeeRequest;
import com.hrm.hrm.dtos.responsedtos.EmployeeResponse;
import com.hrm.hrm.entities.Employee;
import com.hrm.hrm.entities.Job;
import com.hrm.hrm.entities.Role;
import com.hrm.hrm.repositories.EmployeeRepository;
import com.hrm.hrm.repositories.JobRepository;
import com.hrm.hrm.repositories.RoleRepository;
import com.hrm.hrm.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest, employee);

        Job job = jobRepository.findById(employeeRequest.getJobId()).orElse(null);
        employee.setJob(job);

        Set<Role> roles=new HashSet<>(roleRepository.findAllById(employeeRequest.getRoleIds()));
        employee.setRolesList(roles);

        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void updateEmployee(EmployeeRequest employeeRequest){
        Employee employee =employeeRepository.findById(employeeRequest.getId()).orElse(null);
        if(employee != null) {
            BeanUtils.copyProperties(employeeRequest, employee);

            Job job = jobRepository.findById(employeeRequest.getJobId()).orElse(null);
            employee.setJob(job);

            Set<Role> roles =new HashSet<>(roleRepository.findAllById(employeeRequest.getRoleIds()));
            employee.setRolesList(roles);

            employeeRepository.save(employee);
        }
    }

    @Override
    public boolean checkEmployeeExists(Long id){
        return employeeRepository.existsById(id);
    }

    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeResponse getEmployee(Long id){
        EmployeeResponse employeeResponse=new EmployeeResponse();
        Employee employee=employeeRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(employee,employeeResponse);

        if (employee.getJob() != null) {
            employeeResponse.setJobId(employee.getJob().getId());
        }

        Set<Long> roleIds = employee.getRolesList()
                .stream()
                .map(Role::getId)
                .collect(Collectors.toSet());

        employeeResponse.setRoleIds(roleIds);

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployees(){
        List<EmployeeResponse> employeeResponseList =new ArrayList<>();
        List<Employee> employeeList=employeeRepository.findAll();
        for(Employee employee : employeeList){
            EmployeeResponse employeeResponse=new EmployeeResponse();
            BeanUtils.copyProperties(employee,employeeResponse);

            if (employee.getJob() != null) {
                employeeResponse.setJobId(employee.getJob().getId());
            }

            Set<Long> roleIds = employee.getRolesList()
                    .stream()
                    .map(Role::getId)
                    .collect(Collectors.toSet());

            employeeResponse.setRoleIds(roleIds);
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }

    @Override
    public boolean employeeExistsByName(String nic){
       return  employeeRepository.existsByNic(nic);
    }

    @Override
    public boolean employeeExistsByNameandId(String nic,Long id){
        return employeeRepository.existsByNicAndIdNot(nic,id);
    }

    @Override
    public   boolean employeeExistsByEmail(String email){
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public boolean employeeExistsByEmialandId(String email,Long id){
        return employeeRepository.existsByEmailAndIdNot(email,id);
    }
}
