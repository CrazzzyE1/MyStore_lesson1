package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);
}
