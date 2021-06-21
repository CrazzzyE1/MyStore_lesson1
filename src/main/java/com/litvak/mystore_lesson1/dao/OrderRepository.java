package com.litvak.mystore_lesson1.dao;

import com.litvak.mystore_lesson1.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
