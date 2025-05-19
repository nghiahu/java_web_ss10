package com.example.session10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.session10.model.Project;
import com.example.session10.service.project.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private ProductServiceImp productService;
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("projectForm")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    @PostMapping("create")
    public String createProject(@ModelAttribute("project") Project project,
                                @RequestParam("documentFile") MultipartFile file,
                                Model model) {
        try {
            if (!file.isEmpty()) {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String url = (String) uploadResult.get("url");
                if (url == null || url.isEmpty()) {
                    throw new RuntimeException("Invalid URL");
                }
                project.setDocuments(url);
            }
            productService.createProject(project);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/projectForm";
    }

    @PostMapping("update")
    public String updateProject(@ModelAttribute("project") Project project) {
        productService.updateProject(project);
        return "redirect:/projectForm";
    }

    @GetMapping("delete/{id}")
    public String deleteProject(@PathVariable int id) {
        productService.deleteProject(id);
        return "redirect:/projectForm";
    }
}
