package com.example.session10.repository.project;

import com.example.session10.config.ConnectionDB;
import com.example.session10.model.Project;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepositoryImp implements ProjectRepository {

    @Override
    public boolean createProject(Project project) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call addProject(?,?,?)}");
            callSt.setString(1, project.getName());
            callSt.setString(2, project.getDescription());
            callSt.setString(3,project.getDocuments().toString());
            callSt.execute();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean updateProject(Project project) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateProject(?,?,?,?)}");
            callSt.setInt(1, project.getId());
            callSt.setString(2, project.getName());
            callSt.setString(3, project.getDescription());
            callSt.setString(4,project.getDocuments().toString());
            callSt.execute();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteProject(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delProject(?)}");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public List<Project> getAllProjects() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Project> projects = new ArrayList<Project>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getProject()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setDocuments(rs.getString("documents"));
                projects.add(project);
            }
            return projects;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return projects;
    }
}
