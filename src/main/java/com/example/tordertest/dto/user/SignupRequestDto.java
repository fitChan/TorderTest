package com.example.tordertest.dto.user;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor @Getter
public class SignupRequestDto {
    @NotNull
    private String userId;
    @NotNull
    @Size(min = 2, max = 8, message = "이름을 2~8자 사이로 입력해주세요.")
    private String username;
    @NotNull
    @Pattern(regexp="[a-zA-Z0-9]{6,12}", message = "비밀번호는 영어또는 숫자로 포함해서 6~12자리 이내로 입력해주세요.")
    private String password;
    @NotNull
    private String passwordChecker;

    public SignupRequestDto(SignupRequestDto signupRequestDto) {
        this.username=signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.passwordChecker = signupRequestDto.getPasswordChecker();
    }
}
