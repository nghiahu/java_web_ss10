package com.example.session10.service.project;

import com.example.session10.model.Project;
import com.example.session10.repository.project.ProjectRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProjectService{

    @Autowired
    private ProjectRepositoryImp projectRepositoryImp;
    @Override
    public boolean createProject(Project project) {
        return projectRepositoryImp.createProject(project);
    }

    @Override
    public boolean updateProject(Project project) {
        return projectRepositoryImp.updateProject(project);
    }

    @Override
    public boolean deleteProject(int id) {
        return projectRepositoryImp.deleteProject(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepositoryImp.getAllProjects();
    }
}
