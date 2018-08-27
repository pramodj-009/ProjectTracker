package com.demo.trackproject.controller;

import com.demo.trackproject.model.Project;
import com.demo.trackproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public ResponseEntity getAllProjects(){
        return new ResponseEntity(projectService.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "/project",method = RequestMethod.POST)
    public ResponseEntity addProject(@RequestBody Project project){
        projectService.save(project);
        return new ResponseEntity(project,HttpStatus.OK);
    }

    @RequestMapping(value = "/project/{id}",method = RequestMethod.GET)
    public ResponseEntity getProjectById(@PathVariable long id){
        Project project = projectService.get(id);
        if(project == null){
            return new ResponseEntity("Project not found for id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/project",method = RequestMethod.PUT)
    public ResponseEntity updateProject(@RequestBody Project project){
        project = projectService.update(project);
        if(project == null){
            return new ResponseEntity("Project not found for id: "+project.getId(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(project,HttpStatus.OK);
    }

    @RequestMapping(value = "/project/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteProject(@PathVariable long id){
        projectService.delete(id);
        return new ResponseEntity("Deleted Project for id: "+id,HttpStatus.OK);
    }

}
