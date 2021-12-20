package com.mintic.ciclo4.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private int id;
  private int identification;
  private String name;
  private String addrress;
  private int cellPhone;
  private String email;
  private String password;
  private String zone;
  private String type;
}
