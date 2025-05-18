package com.example.session10.repository.project;

import com.example.session10.model.Project;

public interface ProjectRepository {
    boolean createProject(Project project);
    boolean updateProject(Project project);
    boolean deleteProject(int id);
}
