package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser();

    public List<Map<String,String>> findDEMOUser(String idstr);

}