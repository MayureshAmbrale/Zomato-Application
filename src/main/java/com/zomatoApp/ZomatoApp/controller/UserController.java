package com.zomatoApp.ZomatoApp.controller;

import com.zomatoApp.ZomatoApp.dto.LoginDto;
import com.zomatoApp.ZomatoApp.dto.LoginResponseDto;
import com.zomatoApp.ZomatoApp.dto.SignupDto;
import com.zomatoApp.ZomatoApp.dto.UserDto;
import com.zomatoApp.ZomatoApp.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

    @PostMapping("signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto)
    {
        return ResponseEntity.ok(authService.signup(signupDto));
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto, HttpServletResponse response)
    {
        String[] tokens =authService.login(loginDto);
        Cookie cookie = new Cookie("refreshToken",tokens[1]);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }

}
