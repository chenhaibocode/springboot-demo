package com.chenhaibo.service;

import com.chenhaibo.dao.UserRepositoty;
import com.chenhaibo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 15:49 2018/7/26
 */
@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name) {
        User user = null;
        try {
            user = userRepositoty.findByUserName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
