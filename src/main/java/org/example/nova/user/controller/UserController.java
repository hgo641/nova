package org.example.nova.user.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/user")
    public String createUser(@RequestBody UserCreateRequest userCreateRequest
    ) {
        // TODO 유저를 생성해 주세요.
        // TODO 유저의 패스워드는 암호화하여 저장해주세요.
        // TODO 반환값은 변경하셔도 됩니다.
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest loginRequest,
            // TODO Authorization 헤더값에서 jwt를 추출해오세요
    ) {

        // TODO 존재하는 유저인지 DB의 값과 비교해 검증

        // TODO 응답값에 생성한 jwt를 포함해주세요.
        return "LOGIN SUCCESS (token= )";
    }
}
