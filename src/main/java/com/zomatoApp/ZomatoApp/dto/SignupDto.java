package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignupDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}
