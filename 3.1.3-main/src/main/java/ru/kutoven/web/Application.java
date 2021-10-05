package ru.kutoven.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kutoven.web.entity.Role;
import ru.kutoven.web.service.Impl.RoleServiceImpl;
import ru.kutoven.web.service.Impl.UserServiceImpl;
import ru.kutoven.web.entity.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserServiceImpl userService, RoleServiceImpl roleService) {
		return args -> {
			roleService.addNewRole(new Role(null, "ROLE_USER"));
			roleService.addNewRole(new Role(null, "ROLE_ADMIN"));

			userService.addNewUser(new User(null, "etomailolega@yandex.ru", "Oleg", "Kutovenko", LocalDate.of(1989, Month.AUGUST, 8), "123", true, new HashSet<>()));
			userService.addNewUser(new User(null, "tratata@gmail.ru", "Artur", "Pirojkov", LocalDate.of(1999, Month.MARCH, 8), "123", true, new HashSet<>()));

			userService.addRoleToUser("etomailolega@yandex.ru", "ROLE_ADMIN");
			userService.addRoleToUser("etomailolega@yandex.ru", "ROLE_USER");
			userService.addRoleToUser("tratata@gmail.ru", "ROLE_USER");
		};
	}
}
