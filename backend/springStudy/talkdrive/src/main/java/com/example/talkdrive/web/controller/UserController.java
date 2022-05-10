package com.example.talkdrive.web.controller;

import com.example.talkdrive.service.UserService;
import com.example.talkdrive.web.dto.UserRequestDto;
import com.example.talkdrive.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<String> save(@Valid @RequestBody UserRequestDto.UserPost userPostDto) {
        Long id = userService.save(userPostDto);
        System.out.println("id = " + id);
        return new ResponseEntity<>( "회원가입 완료", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<UserResponseDto.FindOne> save(@RequestParam Long loginId) {
        return new ResponseEntity<>(userService.findOne(loginId), HttpStatus.OK);
    }
}
