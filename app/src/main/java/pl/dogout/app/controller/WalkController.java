package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.mapper.DogMapper;
import pl.dogout.app.dto.mapper.WalkMapper;
import pl.dogout.app.dto.response.DogInfoResponse;
import pl.dogout.app.dto.response.UserActiveWalkResponse;
import pl.dogout.app.model.ActiveWalk;
import pl.dogout.app.model.Dog;
import pl.dogout.app.model.Place;
import pl.dogout.app.model.User;
import pl.dogout.app.service.UserService;
import pl.dogout.app.service.WalkService;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/walk")
@CrossOrigin
public class WalkController {


    private final UserService userService;

    private final WalkService walkService;

    private final WalkMapper walkMapper;
    private final DogMapper dogMapper;

    @Autowired
    public WalkController(UserService userService, WalkService walkService) {
        this.userService = userService;
        this.walkService = walkService;
        this.walkMapper = new WalkMapper();
        this.dogMapper = new DogMapper();
    }

    @PostMapping
    public ResponseEntity<String> goForAWalk() {

        // TODO
        ActiveWalk activeWalk = new ActiveWalk("01:00:00", LocalTime.now(), new Place(1L), new User(17L));

        walkService.saveWalk(activeWalk);
        return ResponseEntity.ok("Gone");
    }

    @GetMapping
    public ResponseEntity<?> getActiveWalk(@RequestParam String email) {
        User user = userService.getUserByEmail(email);

        ActiveWalk activeWalk = walkService.getActiveWalkByUser(user);

        if (activeWalk == null)
            return ResponseEntity.ok("User is not on a walk.");

        UserActiveWalkResponse response = walkMapper.getUserActiveWalkResponse(activeWalk);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{placeId}")
    public List<DogInfoResponse> getAllDogsFromPlace(@PathVariable Long placeId) {
        List<Dog> dogs = walkService.getDogsFromPlace(placeId);
        return dogs.stream().map(dogMapper::getDogInfoResponse).toList();
    }
}
