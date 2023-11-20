package com.imd.web.swaptales.dto;

import com.imd.web.swaptales.model.User;
import com.imd.web.swaptales.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;
    private String username;
    private String password;
    private String urlImg;
    private List<Role> permissions = new ArrayList();

    public User getEntity(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCpf(cpf);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setUsername(username);
        user.setPassword(password);
        user.setPermissions(permissions);
        user.setUrlImg(urlImg);

        return user;
    }
}
