package com.mintic.ciclo4.controller;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo4.model.User;
import com.mintic.ciclo4.service.UserService;

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
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
  
  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public Optional<User> getUser(@PathVariable int id) {
    return userService.getUser(id);
  }

  @GetMapping("/all")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/emailexist/{email}")
  public Boolean emailExists(@PathVariable String email) {
    return userService.emailExists(email);
  }

  @GetMapping("/{email}/{password}")
  public Optional<User> autenticate(@PathVariable String email, @PathVariable String password) {
    return userService.autenticate(email, password);
  }

  @PostMapping("/new")
  @ResponseStatus(HttpStatus.CREATED)
  public User save(@RequestBody User user) {
    return userService.save(user);
  }

  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public User update(@RequestBody User user) {
    return userService.save(user);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable int id) {
    userService.delete(id);
  }

}
