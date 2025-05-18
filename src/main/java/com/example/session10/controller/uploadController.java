package com.example.session10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.session10.model.UplaodFile;
import com.example.session10.service.document.DocumentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class uploadController {

    @Autowired
    DocumentServiceImp documentService;
    @Autowired
    Cloudinary cloudinary;

    @GetMapping("uploadFileForm")
    public String uploadFileForm(Model model) {
        model.addAttribute("uplaodFile", new UplaodFile());
        return "uploadFileForm";
    }

    @PostMapping("uploadFile")
    public String uploadFile(@ModelAttribute("uplaodFile") UplaodFile uplaodFile,Model model) {
        try {
            Map uploadResult = cloudinary.uploader().upload(uplaodFile.getFile().getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null && url.isEmpty()) {
                throw  new RuntimeException("Invalid URL");
            }
            documentService.uploadFile(url,uplaodFile.getDescription());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/uploadFileForm";
    }
}
