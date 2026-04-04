package com.thefoods.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thefoods.backend.entity.*;
import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {}