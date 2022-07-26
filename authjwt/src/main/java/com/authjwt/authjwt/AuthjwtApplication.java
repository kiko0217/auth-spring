package com.authjwt.authjwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.authjwt.authjwt.domain.Role;
import com.authjwt.authjwt.domain.User;
import com.authjwt.authjwt.service.UserService;

@SpringBootApplication
public class AuthjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthjwtApplication.class, args);
	}

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner run(UserService userService) {
    return args -> {
      userService.saveRole(new Role(null, "ROLE_USER"));
      userService.saveRole(new Role(null, "ROLE_MANAGER"));
      userService.saveRole(new Role(null, "ROLE_ADMIN"));
      userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

      userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Will Travolta", "will", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Jim Travolta", "jim", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Arnold Travolta", "arnold", "1234", new ArrayList<>()));

      userService.addRoleToUser("john", "ROLE_USER");
      userService.addRoleToUser("john", "ROLE_MANAGER");
      userService.addRoleToUser("will", "ROLE_MANAGER");
      userService.addRoleToUser("jim", "ROLE_ADMIN");
      userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
      userService.addRoleToUser("arnold", "ROLE_ADMIN");
      userService.addRoleToUser("arnold", "ROLE_USER");
    };
  }
}
