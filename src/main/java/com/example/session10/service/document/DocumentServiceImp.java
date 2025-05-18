package com.example.session10.service.document;

import com.example.session10.model.Document;
import com.example.session10.repository.document.DocumentRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImp implements DocumentService {

    @Autowired
    private DocumentRepositoryImp documentRepositoryImp;
    @Override
    public boolean saveDocument(Document document) {
        return documentRepositoryImp.saveDocument(document);
    }

    @Override
    public boolean uploadFile(String file, String description) {
        return documentRepositoryImp.uploadFile(file, description);
    }
}
