package com.example.loginsb;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerLG {

    @PostMapping("/login")
    public String login(@RequestBody User user){
        if(user.getName().equals("admin")&&user.getPassword().equals("123123")){
            return "đăng nhập thành công";
        }else {
            return "đăng nhập thất bại";
        }
    }
}
