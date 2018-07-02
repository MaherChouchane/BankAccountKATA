package com.kata.bankAccount;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.kata.bankAccount.entity.Account;
import com.kata.bankAccount.entity.Customer;
import com.kata.bankAccount.entity.Record;
import com.kata.bankAccount.entity.RecordType;
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
		Record record = new Record();
		Record record2 = new Record();
		Record record3 = new Record();
		account.setClient(customer);
		account.setBalance(15000);
		
		record.setAmount(1000);
		record.setType(RecordType.DEPOSIT);
		
		record2.setAmount(1500);
		record2.setType(RecordType.WITHDRAWAL);
		
		record3.setAmount(200);
		record3.setType(RecordType.DEPOSIT);
		return args -> {
			bankService.addCustomer(customer);
			bankService.addAccount(account);
			bankService.addRecordToAccount(account.getId(), record);
			bankService.addRecordToAccount(account.getId(), record2);
			bankService.addRecordToAccount(account.getId(), record3);
		};
	}
}
