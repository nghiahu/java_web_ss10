package com.example.session10.model;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String ISBN;
    private double price;
    private MultipartFile fileImage;
    private LocalDate publishedDate;

    public Book() {
    }

    public Book(int id, String title, String ISBN, double price, MultipartFile fileImage, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.price = price;
        this.fileImage = fileImage;
        this.publishedDate = publishedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
