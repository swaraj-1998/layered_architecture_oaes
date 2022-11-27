package com.example.oaes_layer.dao;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.bean.User;
import com.example.oaes_layer.util.DbData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public boolean registerUser(User dto) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "Insert into user(username,password,name,email) values(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getEmail());
            if(ps.executeUpdate()>0) {
                flag=true;
            }
        } catch (Exception e) {
            System.out.println("Exception in addUser : e");
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }
    public boolean loginUser(User user) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from user where username = ? && password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception in addUser : e");
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }
}
