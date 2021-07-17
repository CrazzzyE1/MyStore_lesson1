package com.litvak.mystore_lesson1.dao;

import com.litvak.mystore_lesson1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
    User findFirstByActivateCode(String activateCode);
    List<User> findAll();
}
