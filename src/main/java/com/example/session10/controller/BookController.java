package com.example.session10.controller;

import com.example.session10.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @GetMapping("bookForm")
    public String bookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "bookForm";
    }
    @PostMapping("book-save")
    public String bookSave(@ModelAttribute("book") Book book) {
        System.out.println(book.getTitle());
        return "productSuccess";
    }
}
