package com.playground.java.mybatis;

import lombok.Data;

@Data
public class User {
  private int id;
  private String username;
  private String password;
  private String gender;
  private String addr;
}
