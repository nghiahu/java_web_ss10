package com.example.session10.service.project;

import com.example.session10.model.Project;

import java.util.List;

public interface ProjectService {
    boolean createProject(Project project);
    boolean updateProject(Project project);
    boolean deleteProject(int id);
    List<Project> getAllProjects();
}
