package com.example.tordertest.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor @Getter
public class SignupRequestDto {
    private String userId;
    private String username;
    private String password;
    private String passwordChecker;

    public SignupRequestDto(SignupRequestDto signupRequestDto) {
        this.username=signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.passwordChecker = signupRequestDto.getPasswordChecker();
    }
}
