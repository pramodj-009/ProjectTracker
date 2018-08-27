package com.demo.trackproject.service;

import com.demo.trackproject.dao.ProjectDAO;
import com.demo.trackproject.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;
    @Transactional
    public long save(Project project){
        return projectDAO.addProject(project);
    }

    public Project get(long id){
        return projectDAO.getProject(id);
    }

    public List<Project> list(){
        return projectDAO.listProjects();
    }

    @Transactional
    public Project update(Project project){
        return projectDAO.updateProject(project);
    }

    @Transactional
    public void delete(long id){
        projectDAO.deleteProjectById(id);
    }
}
