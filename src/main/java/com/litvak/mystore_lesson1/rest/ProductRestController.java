package com.litvak.mystore_lesson1.rest;

import com.litvak.mystore_lesson1.dto.ProductDTO;
import com.litvak.mystore_lesson1.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO dto){
        productService.addProduct(dto);
    }

}
