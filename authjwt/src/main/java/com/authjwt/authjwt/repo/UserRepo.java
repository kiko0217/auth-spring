package com.authjwt.authjwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authjwt.authjwt.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{
  User findByUsername(String username);
}
