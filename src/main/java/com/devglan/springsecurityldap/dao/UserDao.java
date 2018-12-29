package com.devglan.springsecurityldap.dao;

import com.devglan.springsecurityldap.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
}
