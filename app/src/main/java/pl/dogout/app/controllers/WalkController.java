package pl.dogout.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/walk")
@CrossOrigin
public class WalkController {

    @PostMapping("/go")
    public ResponseEntity<String> goForAWalk() {
        return ResponseEntity.ok("Gone");
    }

    @GetMapping("/active")
    public ResponseEntity<String> getActiveWalk() {
        return ResponseEntity.ok("Active walk");
    }
}
