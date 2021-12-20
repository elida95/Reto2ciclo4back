package com.mintic.ciclo4.controller;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo4.model.Product;
import com.mintic.ciclo4.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable int id) {
    return productService.getProduct(id);
  }

  @GetMapping("/all")
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @PostMapping("/new")
  @ResponseStatus(HttpStatus.CREATED)
  public Product save(@RequestBody Product product) {
    return productService.save(product);
  }

  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Product update(@RequestBody Product product) {
    return productService.save(product);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable int id) {
    productService.delete(id);
  }

}
