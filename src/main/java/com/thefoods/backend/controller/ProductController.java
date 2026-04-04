package com.thefoods.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.thefoods.backend.service.*;
import com.thefoods.backend.dto.*;
import com.thefoods.backend.entity.*;
import java.util.*;
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }
}
