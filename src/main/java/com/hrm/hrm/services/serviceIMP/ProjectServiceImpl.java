package com.hrm.hrm.services.serviceIMP;

import com.hrm.hrm.dtos.requestdtos.ProjectRequest;
import com.hrm.hrm.dtos.responsedtos.ProjectResponse;
import com.hrm.hrm.entities.Employee;
import com.hrm.hrm.entities.Project;
import com.hrm.hrm.repositories.EmployeeRepository;
import com.hrm.hrm.repositories.ProjectRepository;
import com.hrm.hrm.services.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createProject(ProjectRequest projectRequest){
        Project project = new Project();
        BeanUtils.copyProperties(projectRequest, project);

        Employee employee = employeeRepository.findById(projectRequest.getEmployeeId()).orElse(null);
        project.setEmployee(employee);

        projectRepository.save(project);
    }

    @Transactional
    @Override
    public void updateProject(ProjectRequest projectRequest){
        Project project = projectRepository.findById(projectRequest.getId()).orElse(null);

        if (project != null) {
            BeanUtils.copyProperties(projectRequest, project);
            if(projectRequest.getEmployeeId()!=null) {
                Employee employee = employeeRepository.findById(projectRequest.getEmployeeId()).orElse(null);
                project.setEmployee(employee);
            }
            projectRepository.save(project);
        }
    }

    @Override
    public boolean checkProjectExists(Long id) {
        return projectRepository.existsById(id);
    }

    @Override
    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectResponse getProject(Long id) {
        ProjectResponse projectResponse = new ProjectResponse();
        Project project = projectRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(project, projectResponse);
        if (project.getEmployee() != null) {
            projectResponse.setEmployeeId(project.getEmployee().getId());
        }
        return projectResponse;
    }

    @Override
    public List<ProjectResponse> getProjects(){
        List<ProjectResponse> projectResponseList = new ArrayList<>();
        List<Project> projectList = projectRepository.findAll();
        for (Project project : projectList) {
            ProjectResponse projectResponse = new ProjectResponse();
            BeanUtils.copyProperties(project, projectResponse);
            if (project.getEmployee() != null) {
                projectResponse.setEmployeeId(project.getEmployee().getId());
            }
            projectResponseList.add(projectResponse);
        }
        return projectResponseList;
    }

}
