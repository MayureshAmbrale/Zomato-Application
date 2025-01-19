package com.zomatoApp.ZomatoApp.service.Impl;

import com.zomatoApp.ZomatoApp.dto.LoginDto;
import com.zomatoApp.ZomatoApp.dto.SignupDto;
import com.zomatoApp.ZomatoApp.dto.UserDto;
import com.zomatoApp.ZomatoApp.entity.Customer;
import com.zomatoApp.ZomatoApp.entity.User;
import com.zomatoApp.ZomatoApp.enums.Role;
import com.zomatoApp.ZomatoApp.repository.CustomerRepository;
import com.zomatoApp.ZomatoApp.repository.UserRepository;
import com.zomatoApp.ZomatoApp.security.JwtService;
import com.zomatoApp.ZomatoApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {

        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user!= null) throw new RuntimeException("User with "+signupDto.getEmail()+" is already present");

        User newUser = modelMapper.map(signupDto,User.class);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(Set.of(Role.CUSTOMER));
        User savedUser=userRepository.save(newUser);
        Customer customer = new Customer();
        customer.setUser(savedUser);
        customerRepository.save(customer);

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public String[] login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.getAccessToken(user);
        String refreshToken = jwtService.getRefreshToken(user);

        String[] tokens = {accessToken,refreshToken};

        return tokens;
    }
}
