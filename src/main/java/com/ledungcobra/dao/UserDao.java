package com.ledungcobra.dao;

import com.ledungcobra.entites.User;

public interface UserDao<T extends User> {
     T findUserByUserName(String username);
}
