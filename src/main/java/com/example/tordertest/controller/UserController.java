package com.example.tordertest.controller;

import com.example.tordertest.dto.user.SignupRequestDto;
import com.example.tordertest.entity.user.User;
import com.example.tordertest.exception.ApiException;
import com.example.tordertest.repository.UserRepository;
import com.example.tordertest.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody @Valid SignupRequestDto signupRequestDto, Errors error) {
        boolean isExist = userRepository.existsByUsername(signupRequestDto.getUsername());
        if(isExist || error.hasErrors()){
            return ResponseEntity.badRequest().body(error);
        }else {
            userService.registerUser(signupRequestDto);
            return ResponseEntity.ok().build();
        }
    }


    //로그인
    @PostMapping("/login")
    public Long login(@RequestBody  @Valid SignupRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername());
        if (!requestDto.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return user.getId();
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> handle(IllegalArgumentException ex) {
        ApiException apiException = new ApiException(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST
        );
    }
}
