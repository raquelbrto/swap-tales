package com.imd.web.swaptales.controller;

import com.imd.web.swaptales.config.secutiry.TokenService;
import com.imd.web.swaptales.dto.UserDTO;
import com.imd.web.swaptales.dto.AuthenticationDTO;
import com.imd.web.swaptales.dto.LoginResponseDTO;
import com.imd.web.swaptales.model.User;
import com.imd.web.swaptales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword());
        Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token, (User) auth.getPrincipal()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        try{
            User user = userService.getById(id);
            return ResponseEntity.ok(user);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers(){
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try{
            User user = userDTO.getEntity();
            return ResponseEntity.ok(userService.register(user));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO){

        User user = userDTO.getEntity();

        try{
            return ResponseEntity.ok(userService.update(user));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        try{
            userService.deleteById(id);
            return ResponseEntity.ok("Usuario excluido com sucesso");
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
