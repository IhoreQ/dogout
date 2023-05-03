package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.request.PasswordUpdateRequest;
import pl.dogout.app.model.User;
import pl.dogout.app.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request) {
        User user =  userService.getUserByEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.newPassword()));
        userService.saveUser(user);

        return ResponseEntity.ok("Password updated.");
    }
}
