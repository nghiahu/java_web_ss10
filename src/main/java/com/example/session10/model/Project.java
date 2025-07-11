package com.example.session10.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;
    private String documents;

    public Project() {
    }
    public Project(int id, String name, String description, String documents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.documents = documents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }
}
