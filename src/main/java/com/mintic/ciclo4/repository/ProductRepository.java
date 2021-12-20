package com.mintic.ciclo4.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo4.repository.CrudRepository.ProductCrudRepository;
import com.mintic.ciclo4.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  @Autowired
  private ProductCrudRepository productCrudRepository;

  public Optional<Product> getProduct(int id) {
    return productCrudRepository.findById(id);
  }

  public List<Product> getProducts() {
    return productCrudRepository.findAll();
  }

  public Optional<Product> lastProductId() {
    return productCrudRepository.findTopByOrderByIdDesc();
  }

  public Product save(Product product) {
    return productCrudRepository.save(product);
  }

  public Product update(Product product) {
    return productCrudRepository.save(product);
  }

  public void delete(int id) {
    productCrudRepository.deleteById(id);
  }
}
