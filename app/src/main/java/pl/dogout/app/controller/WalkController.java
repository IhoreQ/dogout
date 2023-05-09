package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.mapper.DogMapper;
import pl.dogout.app.dto.mapper.WalkMapper;
import pl.dogout.app.dto.request.WalkStartRequest;
import pl.dogout.app.dto.response.DogInfoResponse;
import pl.dogout.app.dto.response.UserActiveWalkResponse;
import pl.dogout.app.model.ActiveWalk;
import pl.dogout.app.model.Dog;
import pl.dogout.app.model.Place;
import pl.dogout.app.model.User;
import pl.dogout.app.service.UserService;
import pl.dogout.app.service.WalkService;

import java.time.LocalTime;
import java.util.Collection;
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
    public ResponseEntity<String> goForAWalk(@RequestBody WalkStartRequest request) throws Exception {

        User user = userService.getUserByEmail(request.email());

        if (!user.hasDog()) {
            throw new Exception("User has no dog!");
        }

        if (!user.getActiveWalks().isEmpty()) {
            throw new Exception("User is already on a walk!");
        }

        ActiveWalk activeWalk = new ActiveWalk(request.timeOfAWalk(), LocalTime.now(), new Place(request.placeId()), user);

        walkService.saveWalk(activeWalk);
        return ResponseEntity.ok("Gone");
    }

    @GetMapping
    public ResponseEntity<?> getActiveWalk(@RequestParam String email) {
        User user = userService.getUserByEmail(email);

        ActiveWalk activeWalk = walkService.getActiveWalkByUser(user);

        if (activeWalk == null)
            return ResponseEntity.ok(false);

        UserActiveWalkResponse response = walkMapper.getUserActiveWalkResponse(activeWalk);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{placeId}")
    public List<DogInfoResponse> getAllDogsFromPlace(@PathVariable Long placeId) {
        List<Dog> dogs = walkService.getDogsFromPlace(placeId);
        return dogs.stream()
                .map(dogMapper::getDogInfoResponse)
                .toList();
    }

    @DeleteMapping
    public ResponseEntity<String> finishWalk(@RequestParam String email) throws Exception {

        User user = userService.getUserByEmail(email);

        Collection<ActiveWalk> activeWalks = user.getActiveWalks();

        if (activeWalks.isEmpty()) {
            throw new Exception("User is not on a walk!");
        }

        ActiveWalk activeWalk = activeWalks.stream().findFirst().get();
        walkService.finishWalk(activeWalk);

        return ResponseEntity.ok("Finished.");
    }
}
