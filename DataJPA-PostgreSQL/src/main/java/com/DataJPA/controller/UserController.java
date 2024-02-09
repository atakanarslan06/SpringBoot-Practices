package com.DataJPA.controller;

import com.DataJPA.dto.UserDto;
import com.DataJPA.entity.User;
import com.DataJPA.repository.IUserRepository;
import com.DataJPA.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @PostMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getList(){
        return ResponseEntity.ok(userService.getAll());
    }
    //changes
    //changes
    //changes
}
