package com.shopease.shopease.controller;

import com.shopease.shopease.entity.User;
import com.shopease.shopease.repository.UserRepository;
import com.shopease.shopease.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    // ================= REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> body) {

        String name = body.get("name");
        String email = body.get("email");
        String password = body.get("password");

        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return ResponseEntity.ok("User Registered Successfully");
    }


    // ================= LOGIN =================

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        System.out.println("Email = " + email);
        System.out.println("Password = " + password);

        var userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return new ResponseEntity<>("User not registered", HttpStatus.UNAUTHORIZED);
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("Invalid User", HttpStatus.UNAUTHORIZED);
        }

        String token = jwtUtil.generateToken(email);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "userId", user.getId()
        ));

    }

}