package com.mintic.ciclo4.repository.CrudRepository;

import java.util.Optional;

import com.mintic.ciclo4.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCrudRepository extends MongoRepository<Product, Integer> {
  public Optional<Product> findTopByOrderByIdDesc();
}
