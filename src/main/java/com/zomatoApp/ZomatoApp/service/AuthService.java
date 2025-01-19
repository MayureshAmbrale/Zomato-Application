package com.zomatoApp.ZomatoApp.service;

import com.zomatoApp.ZomatoApp.dto.LoginDto;
import com.zomatoApp.ZomatoApp.dto.SignupDto;
import com.zomatoApp.ZomatoApp.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {
    UserDto signup(SignupDto signupDto);
    String[] login(LoginDto loginDto);

}
