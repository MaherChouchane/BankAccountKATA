package com.kata.bankAccount;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.kata.bankAccount.entity.Account;
import com.kata.bankAccount.entity.Customer;
import com.kata.bankAccount.service.BankService;

@SpringBootApplication
@EnableJpaAuditing
public class KataBankAccountApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KataBankAccountApplication.class, args);	
	}
	@Bean
	public CommandLineRunner run(BankService bankService) {
		Account account = new Account();
		Customer customer = new Customer();
		account.setClient(customer);
		account.setBalance(15000);
		return args -> {
			bankService.addCustomer(customer);
			bankService.addAccount(account);
		};
	}
}
