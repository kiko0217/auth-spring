package com.authjwt.authjwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authjwt.authjwt.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
