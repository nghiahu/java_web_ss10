package com.example.session10.service.project;

import com.example.session10.model.Project;

public interface ProjectService {
    boolean createProject(Project project);
    boolean updateProject(Project project);
    boolean deleteProject(int id);
}
