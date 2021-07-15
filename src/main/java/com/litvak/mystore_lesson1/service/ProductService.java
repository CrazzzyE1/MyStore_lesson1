package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void addToUserBucket(Long productId, String username);

    void addProduct(ProductDTO dto);

    ProductDTO getById(Long id);
}
