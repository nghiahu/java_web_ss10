package com.example.session10.model;

import org.springframework.web.multipart.MultipartFile;

public class UplaodFile {
    MultipartFile file;
    String description;

    public UplaodFile() {
    }

    public UplaodFile(MultipartFile file, String description) {
        this.file = file;
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
