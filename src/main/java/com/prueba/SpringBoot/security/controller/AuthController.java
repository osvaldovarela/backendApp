package com.prueba.SpringBoot.security.controller;

import com.prueba.SpringBoot.dto.Message;
import com.prueba.SpringBoot.security.dto.JwtDto;
import com.prueba.SpringBoot.security.dto.LoginUser;
import com.prueba.SpringBoot.security.dto.NewUser;
import com.prueba.SpringBoot.security.entity.Rol;
import com.prueba.SpringBoot.security.entity.User;
import com.prueba.SpringBoot.security.enums.RolName;
import com.prueba.SpringBoot.security.service.RolService;
import com.prueba.SpringBoot.security.service.UserService;
import com.prueba.SpringBoot.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Invalid fields."), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new Message("Email already exists."), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUsername(newUser.getUsername())) {
            return new ResponseEntity(new Message("Username already exists."), HttpStatus.BAD_REQUEST);
        }
        User user = new User(newUser.getEmail(), newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRoleName(RolName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRoleName(RolName.ROLE_ADMIN).get());
        }

        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("User saved."), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Invalid fields."), HttpStatus.BAD_REQUEST);
        }
        if (!userService.existsByUsername(loginUser.getUsername())) {
            return new ResponseEntity(new Message("Username doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication
                = authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
