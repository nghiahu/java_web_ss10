package com.example.session10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.session10.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class ProfileController {

    @Autowired
    private final ServletContext servletContext;
    @Autowired
    private Cloudinary cloudinary;

    public ProfileController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping("uploadForm")
    public String uploadForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "uploadForm";
    }

    @PostMapping("uploadAvatar")
    public String uploadAvatar(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        MultipartFile file = userProfile.getAvatar();
//        if(file != null && !file.isEmpty()) {
//            String fileName = file.getOriginalFilename();
//             long fileSize = file.getSize();
//
//             String uploadDir = servletContext.getRealPath("/uploads");
//             File fileUpload = new File(uploadDir);
//             if(!fileUpload.exists()) {
//                 fileUpload.mkdirs();
//             }
//
//             try {
//                 file.transferTo(new File(fileUpload, fileName));
//             }catch (IOException e) {
//                 e.printStackTrace();
//             }
//        }
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null && url.isEmpty()) {
                throw  new RuntimeException("Invalid URL");
            }
            model.addAttribute("ulr", url);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "uploadSuccess";
    }


}
