package com.tripleclub.api;

import com.tripleclub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        String result = "User Id : "+ id + "\n현재 적립된 포인트 : " + userService.getUserPoint(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
