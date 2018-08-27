package com.demo.trackproject.dao.impl;

import com.demo.trackproject.dao.ProjectDAO;
import com.demo.trackproject.model.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long addProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
        return project.getId();
    }

    @Override
    public Project getProject(long projectId) {
        Project project = (Project) sessionFactory.getCurrentSession().get(Project.class,projectId);
        return project;
    }


    @Override
    public List<Project> listProjects() {
        List<Project> projects = sessionFactory.getCurrentSession().createCriteria(Project.class).list();
        return projects;
    }

    @Override
    public Project updateProject(Project project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
        return project;
    }

    @Override
    public void deleteProject(Project project) {
        sessionFactory.getCurrentSession().delete(project);
    }


    @Override
    public Project updateProjectById(long projectId, Project project) {
        Project newProject = (Project) sessionFactory.getCurrentSession().get(Project.class,projectId);
        newProject.setName(project.getName());
        newProject.setDescription(project.getDescription());
        newProject.setEmployees(project.getEmployees());
        newProject.setStartDate(project.getStartDate());
        newProject.setEndDate(project.getEndDate());
        this.updateProject(newProject);
        return newProject;
    }

    @Override
    public void deleteProjectById(long projectId) {
        Project project = (Project) sessionFactory.getCurrentSession().get(Project.class,projectId);
        this.deleteProject(project);
    }
}
