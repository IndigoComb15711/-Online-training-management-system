package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.controller.vm.ResponseViewModel;
import com.example.DuLieuQuanLyDaoTao.entity.User;
import com.example.DuLieuQuanLyDaoTao.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseViewModel> register(@RequestBody User user) {
        try {
            user.setRole("ADMIN");
            User savedUser = userService.register(user);
            if (savedUser != null) {
                return ResponseEntity.ok().body(new ResponseViewModel("test", 200, true));
            }
            return ResponseEntity.badRequest().body(null);

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
