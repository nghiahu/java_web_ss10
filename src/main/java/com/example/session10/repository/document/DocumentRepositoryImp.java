package com.example.session10.repository.document;

import com.example.session10.config.ConnectionDB;
import com.example.session10.model.Document;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class DocumentRepositoryImp implements DocumentRepository {

    @Override
    public boolean saveDocument(Document document) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call uploadDocument(?,?,?)}");
            callSt.setString(1, document.getTitle());
            callSt.setString(2, document.getDescription());
            callSt.setString(3,document.getFile().toString());
            callSt.execute();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean uploadFile(String file, String description) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call uploadFile(?,?)}");
            callSt.setString(1, file);
            callSt.setString(2, description);
            callSt.execute();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
