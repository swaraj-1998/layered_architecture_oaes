package com.example.oaes_layer.service;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.bean.User;
import com.example.oaes_layer.dao.UserDAO;

public class UserService {
    public boolean registerUser(User user) { //called from controller
        return new UserDAO().registerUser(user);
    }
    public boolean loginUser(User user) { //called from controller
        return new UserDAO().loginUser(user);
    }
}
