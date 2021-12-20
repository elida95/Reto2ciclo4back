package com.mintic.ciclo4.service;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo4.repository.UserRepository;
import com.mintic.ciclo4.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public Optional<User> getUser(int id) {
    return userRepository.getUser(id);
  }

  public List<User> getUsers() {
    return userRepository.getUsers();
  }

  public Boolean emailExists(String email) {
    return userRepository.emailExists(email);
  }

  public Optional<User> autenticate(String email, String password) {
    return userRepository.autenticate(email, password);
  }

  public User save(User user) {
    if (user.getId() == 0) {
      if (userRepository.lastUserId().isEmpty()) {
        user.setId(1);
      } else {
        user.setId(userRepository.lastUserId().get().getId() + 1);
      }
    }

    return userRepository.save(user);
  }

  public void delete(int id) {
    if (userRepository.getUser(id).isPresent()) {
      userRepository.delete(id);
    }
  }
}