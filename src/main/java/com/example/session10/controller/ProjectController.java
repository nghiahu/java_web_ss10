package com.example.session10.controller;

import com.example.session10.model.Project;
import com.example.session10.service.project.ProductServiceImp;
import com.example.session10.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProductServiceImp productService;

    @GetMapping("projectForm")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    @PostMapping("create")
    public String createProject(@ModelAttribute("project") Project project,
                                @RequestParam("files") List<MultipartFile> files) {

        productService.createProject(project);
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
