package com.devglan.springsecurityldap.service.impl;

import com.devglan.springsecurityldap.dao.UserDao;
import com.devglan.springsecurityldap.dto.UserDto;
import com.devglan.springsecurityldap.model.User;
import com.devglan.springsecurityldap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(user -> users.add(user.toUserDto()));
        return users;
    }

    @Override
    public User findOne(long id) {
        return userDao.findById(id).get();
    }

}
