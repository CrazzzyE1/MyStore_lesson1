package com.litvak.mystore_lesson1.dao;

import com.litvak.mystore_lesson1.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
