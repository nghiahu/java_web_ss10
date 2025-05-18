package com.example.session10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.session10.model.Document;
import com.example.session10.service.document.DocumentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class DocumentController {

    @Autowired
    private DocumentServiceImp documentService;
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("documentForm")
    public String documentForm(Model model) {
        model.addAttribute("document", new Document());
        return "documentForm";
    }

    @PostMapping("saveDocument")
    public String saveDocument(@ModelAttribute("document") Document document, Model model) {
        try {
            Map uploadResult = cloudinary.uploader().upload(document.getFile().getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null && url.isEmpty()) {
                throw  new RuntimeException("Invalid URL");
            }
            documentService.saveDocument(document);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/documentForm";
    }
}
