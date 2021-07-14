package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    void saveOrder(Order order);
    Order getOrder(Long id);
}
