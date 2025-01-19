package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.entity.User;
import com.zomatoApp.ZomatoApp.enums.Role;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;

    private User user;

}
