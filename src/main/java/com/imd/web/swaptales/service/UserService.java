package com.imd.web.swaptales.service;

import com.imd.web.swaptales.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User getById(Long id);

    User update(User user);

    void deleteById(Long id);

    List<User> getAllUsers();

    User findAccountByEmailAndPassword(String email, String password);

    User followUser(Long idUser, User user);

    User unfollowUser(Long idUser, User user);

    List<User> getAllFollowers(Long idUser);

    List<User> getAllFollowings(Long idUser);
    List<User> listTopUsers();
}
