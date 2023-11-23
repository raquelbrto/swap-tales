package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.model.Role;
import com.imd.web.swaptales.model.User;
import com.imd.web.swaptales.repository.UserRepository;
import com.imd.web.swaptales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);

        if(user.getPermissions() == null || user.getPermissions().isEmpty()){
            user.setPermissions(new ArrayList<>());
            user.getPermissions().add(Role.USER);
        }

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        Optional userOptional = userRepository.findById(user.getId());
        if(userOptional.isPresent()){
            User userBD = (User) userOptional.get();
            if(user.getTelephone() != null && user.getTelephone() != ""){
                userBD.setTelephone(user.getTelephone());
            }

            if(user.getName() != null && user.getName() != ""){
                userBD.setName(user.getName());
            }

            return userRepository.save(userBD);
        }else{
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findAccountByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public User followUser(Long idUser, User user) {
        User userBD = userRepository.findById(idUser).get();
        userBD.getFollowers().add(user);
        userBD.setCountFollowers((long) userBD.getFollowers().size());
        userRepository.save(userBD);
        return userBD;
    }

    @Override
    public List<User> listTopUsers() {
        return userRepository.listTopUsers();
    }
}
