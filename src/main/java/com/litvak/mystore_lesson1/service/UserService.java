package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.User;
import com.litvak.mystore_lesson1.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);

    void save(User user);

    List<UserDTO> getAll();

    User findByName(String name);

    void updateProfile(UserDTO userDTO);

    boolean activateUser(String activateCode);
}
