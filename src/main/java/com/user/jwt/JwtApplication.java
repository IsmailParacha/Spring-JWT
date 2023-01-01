package com.user.jwt;

import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(this.passwordEncoder.encode("amir"));
		// try {
		// Role role = new Role();
		// role.setId(AppConstants.ADMIN);
		// role.setName("ROLE_ADMIN");
		// Role role1 = new Role();
		// role1.setId(AppConstants.NORMAL);
		// role1.setName("ROLE_EMP");
		// // List<Role> roles=List.of(role,role1);
		// this.roleRepo.saveAll(List.of(role, role1));

		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

}
