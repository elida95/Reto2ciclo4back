package com.mintic.ciclo4.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo4.repository.CrudRepository.UserCrudRepository;
import com.mintic.ciclo4.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  @Autowired
  private UserCrudRepository userCrudRepository;

  public Optional<User> getUser(int id) {
    return userCrudRepository.findById(id);
  }

  public List<User> getUsers() {
    return userCrudRepository.findAll();
  }

  public Boolean emailExists(String email) {
    return userCrudRepository.findByEmail(email).isPresent();
  }

  public Optional<User> autenticate(String email, String password) {
    return userCrudRepository.findByEmailAndPassword(email, password);
  }

  public Optional<User> lastUserId() {
    return userCrudRepository.findTopByOrderByIdDesc();
  }

  public User save(User user) {
    return userCrudRepository.save(user);
  }

  public User update(User user) {
    return userCrudRepository.save(user);
  }

  public void delete(int id) {
    userCrudRepository.deleteById(id);
  }
}
