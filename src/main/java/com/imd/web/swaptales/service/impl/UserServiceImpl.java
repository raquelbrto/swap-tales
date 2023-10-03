package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.model.User;
import com.imd.web.swaptales.repository.UserRepository;
import com.imd.web.swaptales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
            if(user.getTelephone() != null){
                userBD.setTelephone(user.getTelephone());
            }

            if(user.getName() != null){
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
}
