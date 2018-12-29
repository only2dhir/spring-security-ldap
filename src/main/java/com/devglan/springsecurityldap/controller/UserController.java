package com.devglan.springsecurityldap.controller;

import com.devglan.springsecurityldap.dto.ApiResponse;
import com.devglan.springsecurityldap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserService userService;

    //@Secured({ROLE_ADMIN})
    @GetMapping
    public ApiResponse listUser(){
        log.info("received request to list user");
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findAll());
    }

    //@Secured({ROLE_USER})
    @GetMapping(value = "/{id}")
    public ApiResponse getUser(@PathVariable long id){
        log.info("received request to update user %s");
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findOne(id));
    }

}
