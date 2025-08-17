package com.nttdata.microservices.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.microservices.catalog.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    
}
