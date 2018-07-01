package com.kata.bankAccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.bankAccount.entity.Account;
import com.kata.bankAccount.entity.Customer;
import com.kata.bankAccount.entity.Record;
import com.kata.bankAccount.entity.RecordType;
import com.kata.bankAccount.exception.BusinessException;
import com.kata.bankAccount.exception.ExceptionType;
import com.kata.bankAccount.repository.AccountRepository;
import com.kata.bankAccount.repository.CustomerRepository;
import com.kata.bankAccount.repository.RecordRepository;

@Service
public class BankService {

	private final AccountRepository accountRepository;
	private final RecordRepository recordRepository;
	private final CustomerRepository customerRepository;

	@Autowired
	public BankService(AccountRepository accountRepository, RecordRepository recordRepository,
			CustomerRepository customerRepository) {
		this.accountRepository = accountRepository;
		this.recordRepository = recordRepository;
		this.customerRepository = customerRepository;
	}

	public void addAccount(Account account) {
		accountRepository.save(account);
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Optional<Account> getAccount(long id) throws BusinessException {
		Optional<Account> account = accountRepository.findById(id);
		if (account == null || !account.isPresent())
			throw new BusinessException(ExceptionType.ACCOUNT_NOT_FOUND);

		return account;
	}

	public Record addRecordToAccount(long accountId, Record record) throws BusinessException {
		Account account = getAccount(accountId).get();
		record.setAccount(account);
		account.setBalance(calculateBalance(account.getBalance(), record));
		accountRepository.save(account);
		return recordRepository.save(record);

	}

	public float calculateBalance(float balance, Record record) throws BusinessException {

		if (RecordType.DEPOSIT.equals(record.getType())) {
			balance += record.getAmount();
		} else {
			if (balance == 0 || balance < record.getAmount()) {
				throw new BusinessException(ExceptionType.OPERATION_NOT_ALLOWED);
			}
			balance -= record.getAmount();
		}
		return balance;
	}

	public List<Record> getRecordsByAccountId(Account account) {
		return recordRepository.findByAccount(account);

	}

}
