package com.demo.trackproject.dao;

import com.demo.trackproject.model.Project;

import java.util.List;

public interface ProjectDAO {
    public long addProject(Project project);
    public Project getProject(long projectId);
    public List<Project> listProjects();
    public Project updateProject(Project project);
    public void deleteProject(Project project);
    public Project updateProjectById(long projectId,Project project);
    public void deleteProjectById(long projectId);
}
