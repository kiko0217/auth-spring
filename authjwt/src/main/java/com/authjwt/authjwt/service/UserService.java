package com.authjwt.authjwt.service;

import java.util.List;

import com.authjwt.authjwt.domain.Role;
import com.authjwt.authjwt.domain.User;

public interface UserService {
  User saveUser(User user);
  Role saveRole(Role role);
  void addRoleToUser(String username, String roleName);
  User getUser(String username);
  List<User> getUsers();
}
