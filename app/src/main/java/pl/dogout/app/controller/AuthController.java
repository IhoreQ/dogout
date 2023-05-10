package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.request.LoginRequest;
import pl.dogout.app.dto.request.UserAddRequest;
import pl.dogout.app.dto.response.JwtTokenResponse;
import pl.dogout.app.service.AuthService;
import pl.dogout.app.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public AuthController(AuthService authService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> authenticateUser(@RequestBody LoginRequest loginRequest) throws UsernameNotFoundException {

        String token = "";

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
            if (authentication.isAuthenticated())
                token = jwtService.generateToken(loginRequest.email());

        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new JwtTokenResponse(token));
        }

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserAddRequest request) {

        if (authService.userExists(request)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        authService.addUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("User logged out!");
    }

}
