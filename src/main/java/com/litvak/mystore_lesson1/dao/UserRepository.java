package com.litvak.mystore_lesson1.dao;

import com.litvak.mystore_lesson1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
    User findFirstByActivateCode(String activateCode);
}
