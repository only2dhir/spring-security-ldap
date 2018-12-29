package com.devglan.springsecurityldap.service;

import com.devglan.springsecurityldap.dto.UserDto;
import com.devglan.springsecurityldap.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    User findOne(long id);
}
