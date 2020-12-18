package com.example.sqlserver.sqlserver.repository;


import com.example.sqlserver.sqlserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByType(String type);
}
