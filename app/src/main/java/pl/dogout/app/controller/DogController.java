package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.mapper.DogMapper;
import pl.dogout.app.dto.request.DogAddRequest;
import pl.dogout.app.dto.response.DogInfoResponse;
import pl.dogout.app.model.Dog;
import pl.dogout.app.model.User;
import pl.dogout.app.service.DogService;
import pl.dogout.app.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/dog")
@CrossOrigin
public class DogController {

    private final DogService dogService;
    private final UserService userService;
    private final DogMapper dogInfoMapper;

    @Autowired
    public DogController(DogService dogService, UserService userService) {
        this.dogService = dogService;
        this.userService = userService;
        this.dogInfoMapper = new DogMapper();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addDog(@RequestBody DogAddRequest dogAddRequest) throws Exception {
        // TODO named exceptions
        User user = userService.getUserByEmail(dogAddRequest.email());
        if (user.hasDog())
            throw new Exception("User already has a dog!");

        boolean isAdded = dogService.addDog(user, dogAddRequest);

        if (!isAdded)
            throw new Exception("An error occurred while adding a dog!");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getDogInfo(@RequestParam String email) {

        User user = userService.getUserByEmail(email);
        if (!user.hasDog())
            return ResponseEntity.ok("User does not have a dog yet.");

        Dog dog = dogService.getDogInfo(user);
        DogInfoResponse response = dogInfoMapper.getDogInfoResponse(dog);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{placeId}")
    public List<Dog> getAllDogsFromPlace(@PathVariable Long placeId) {
        return dogService.getDogsFromPlace(placeId);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteDog(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        boolean isDeleted = dogService.deleteDog(user);

        return isDeleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
