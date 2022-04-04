package com.example.tordertest.service.user;


import com.example.tordertest.dto.user.SignupRequestDto;
import com.example.tordertest.entity.user.Role;
import com.example.tordertest.entity.user.User;
import com.example.tordertest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordChecker = requestDto.getPasswordChecker();

        if (!passwordChecker.equals(password)) {
            throw new IllegalArgumentException("비밀번호 확인 필요");
        } else {
            User user = User.builder()
                    .username(username)
                    .password(password)
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
        }
    }
}

