package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.dao.OrderRepository;
import com.litvak.mystore_lesson1.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
