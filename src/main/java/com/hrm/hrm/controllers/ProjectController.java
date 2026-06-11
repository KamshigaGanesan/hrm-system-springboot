package com.hrm.hrm.controllers;

import com.hrm.hrm.dtos.requestdtos.ProjectRequest;
import com.hrm.hrm.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")

@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping(value="/project-title")
    public ResponseEntity<Object> createProject(@RequestBody ProjectRequest projectRequest){
        projectService.createProject(projectRequest);
        return ResponseEntity.ok("Project Created Successfully");
    }

    @PutMapping("/project-title")
    public ResponseEntity<Object> updateProject(@RequestBody ProjectRequest projectRequest){
        projectService.updateProject(projectRequest);
        return ResponseEntity.ok("Project Updated Successfully");
    }

    @DeleteMapping("/project-title/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long id){
        if(!projectService.checkProjectExists(id)){
            return ResponseEntity.ok("Project Not Found");
        }
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project Deleted Successfully");
    }

    @GetMapping("/project-title/{id}")
    public ResponseEntity<Object> getProject(@PathVariable Long id) {

        if(!projectService.checkProjectExists(id)){
            return ResponseEntity.ok("Project Not Found");
        }
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @GetMapping("/project-title")
    public ResponseEntity<Object> getProjects(){
        return ResponseEntity.ok(projectService.getProjects());
    }
 }
