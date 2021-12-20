package com.mintic.ciclo4.repository.CrudRepository;

import java.util.Optional;

import com.mintic.ciclo4.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository extends MongoRepository<User, Integer>{
  public Optional<User> findByEmail(String email);

  public Optional<User> findByEmailAndPassword(String email, String password);

  public Optional<User> findTopByOrderByIdDesc();
}
