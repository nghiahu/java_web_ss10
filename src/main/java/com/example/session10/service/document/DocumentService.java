package com.example.session10.service.document;

import com.example.session10.model.Document;

public interface DocumentService {
    boolean saveDocument(Document document);
    boolean uploadFile(String file,String description);
}
