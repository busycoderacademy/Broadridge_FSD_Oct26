package com.bankapp;
import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner{

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private UserEntityService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		accountRepo.save(new Account("raj",5000));
//		accountRepo.save(new Account("ekta",5000));
//		userService.addUserEntity(new UserEntity("raj", passwordEncoder.encode("raj123"), List.of("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
//		userService.addUserEntity(new UserEntity("ekta",passwordEncoder.encode("ekta123"), List.of("ROLE_MGR","ROLE_CLERK")));
//		userService.addUserEntity(new UserEntity("gun",passwordEncoder.encode("gun123"), List.of("ROLE_CLERK")));
	}
}
