package com.hrm.hrm.services;

import com.hrm.hrm.dtos.requestdtos.ProjectRequest;
import com.hrm.hrm.dtos.responsedtos.ProjectResponse;

import java.util.List;

public interface ProjectService {
    void createProject(ProjectRequest projectRequest);
    void updateProject(ProjectRequest projectRequest);
    void deleteProject(Long id);
    boolean checkProjectExists(Long id);
    ProjectResponse getProject(Long id);
    List<ProjectResponse> getProjects();

}
