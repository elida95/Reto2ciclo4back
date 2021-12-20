package com.mintic.ciclo4.service;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo4.repository.ProductRepository;
import com.mintic.ciclo4.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Optional<Product> getProduct(int id) {
    return productRepository.getProduct(id);
  }

  public List<Product> getProducts() {
    return productRepository.getProducts();
  }

  public Product save(Product product) {
    if (product.getId() == 0) {
      if (productRepository.lastProductId().isEmpty()) {
        product.setId(1);
      } else {
        product.setId(productRepository.lastProductId().get().getId() + 1);
      }
    }

    return productRepository.save(product);
  }

  public void delete(int id) {
    if (productRepository.getProduct(id).isPresent()) {
      productRepository.delete(id);
    }
  }
}