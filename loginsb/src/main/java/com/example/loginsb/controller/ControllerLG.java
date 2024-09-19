package com.example.loginsb.controller;

import com.example.loginsb.model.User;
import com.example.loginsb.service.ServiceLG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerLG {

    private ServiceLG service;

    @Autowired
    public ControllerLG(ServiceLG serviceLG) {
        this.service = serviceLG;
    }
    //Login
    @PostMapping("/login")
    public String login1(@RequestParam String name,@RequestParam String password){
       boolean check = service.checkLogin(name, password);
       if(check){
           return "thành công";
       }else {
           return "thất bại";
       }
    }
    //getAll
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // Lấy user theo ID dùng @PathVariable
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        User user = service.getUserById(id);
        if (user != null) {
            return "người cần tìm :"+ user.toString() ; 
        } else {
            return "k tồn tại"; 
        }
    }
   //Lấy user theo tên dùng @RequestParam
    @GetMapping("/ten")
    public String getUserByName(@RequestParam String name){
        User user = service.getUserByName(name);
        if(user !=null){
            return "người cần tìm :"+user.toString();
        }else {
            return "k tồn tại";
        }
    }

    // Thêm user mới
//    @PostMapping
//    public String addUser(@RequestBody User user) {
//        User user1 = service.addUser(user);
//        return "thêm thành công"+user.toString();
//    }
//  Thêm user mới  có thông báo và dùng @RequestParam
    @PostMapping
    public String addUser(@RequestParam Long id,@RequestParam String name, @RequestParam String password) {
        User user = new User();

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        User createdUser = service.addUser(user);
        return "Thêm user thành công: " + createdUser.toString();
    }

    // Cập nhật thông tin user
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = service.updateUser(id, updatedUser);
        if (user != null) {
            return "update thành công"+user.toString();
        } else {
            return "update thất bại"; //
        }
    }

    // Xóa user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.deleteUser(id)) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }
}
