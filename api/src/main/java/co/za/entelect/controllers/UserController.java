package co.za.entelect.controllers;

import co.za.entelect.dtos.UserDto;
import co.za.entelect.dtos.UserRequestDto;
import co.za.entelect.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequest){
        UserDto newUser = userService.createUser(userRequest);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
