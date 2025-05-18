package com.example.session10.repository.account;

import com.example.session10.config.ConnectionDB;
import com.example.session10.model.Account;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class AccountRepositoryImp implements AccountRepository {
    @Override
    public boolean addProduct(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call addAccount(?,?,?)}");
            callSt.setString(1, account.getUsername());
            callSt.setString(2, account.getPassword());
            callSt.setString(3, account.getEmail());
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
