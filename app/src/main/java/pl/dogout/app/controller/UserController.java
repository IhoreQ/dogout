package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.controller.dto.request.PasswordUpdateRequest;
import pl.dogout.app.model.User;
import pl.dogout.app.service.JwtService;
import pl.dogout.app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PatchMapping("/password")
    public ResponseEntity<Boolean> updatePassword(@RequestHeader("Authorization") String header, @RequestBody PasswordUpdateRequest request) {

        String email = jwtService.extractEmailFromHeader(header);
        User user = userService.getUserByEmail(email);

        if (!passwordEncoder.matches(request.oldPassword(), user.getPassword())) {
            return ResponseEntity.ok(false);
        }

        user.setPassword(passwordEncoder.encode(request.newPassword()));
        userService.saveUser(user);

        return ResponseEntity.ok(true);
    }
}