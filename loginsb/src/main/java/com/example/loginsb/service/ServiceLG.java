package com.example.loginsb.service;

import com.example.loginsb.model.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public
class ServiceLG {

    private List<User> list = new ArrayList<>();

    public ServiceLG(){
        list.add(new User(1L,"an","123"));
        list.add(new User(2L,"duy","123123"));
        list.add(new User(3L,"huy","123456"));
    }

    public boolean checkLogin(String name, String password) {
        for (User user : list) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers() {
        return list;
    }

    // Tìm kiếm User theo ID
    public User getUserById(Long id) {
        for (User user : list) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public User getUserByName(String name){
        for (User user :list){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    // Thêm mới một User
    public User addUser(User user) {
        list.add(user);
        return user;
    }

    // Cập nhật thông tin User theo ID
    public User updateUser(Long id, User updatedUser) {
        for (User user : list) {
            if (user.getId().equals(id)) {
                user.setName(updatedUser.getName());
                user.setPassword(updatedUser.getPassword());
                return user;
            }
        }
        return null;
    }

    // Xóa User theo ID
    public boolean deleteUser(Long id) {
        return list.removeIf(user -> user.getId().equals(id));
    }


}



