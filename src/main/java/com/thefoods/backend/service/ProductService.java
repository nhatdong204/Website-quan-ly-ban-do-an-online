package com.thefoods.backend.service;
import com.thefoods.backend.dto.*;
import com.thefoods.backend.entity.*;
import java.util.*;

public interface ProductService {
    List<Product> getAll();
    Product create(Product product);
}

