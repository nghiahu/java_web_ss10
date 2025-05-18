package com.example.session10.repository.document;

import com.example.session10.model.Document;

public interface DocumentRepository {
    boolean saveDocument(Document document);

    boolean uploadFile(String file,String description);
}
