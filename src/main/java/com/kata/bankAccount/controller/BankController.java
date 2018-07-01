package com.kata.bankAccount.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.bankAccount.entity.Account;
import com.kata.bankAccount.entity.Record;
import com.kata.bankAccount.exception.BusinessException;
import com.kata.bankAccount.service.BankService;

@RestController
@RequestMapping("/bankAccount/{idAccount}")
public class BankController {

	private final BankService bankService;

	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	/**
	 *	return account
	 * @param idAccount
	 * @throws BusinessException
	 */
	@GetMapping()
	Optional<Account> getAccount(@PathVariable Long idAccount) throws BusinessException {		
		return bankService.getAccount(idAccount);
	}

	/**
	 * add new record to account
	 * @param idAccount
	 * @throws BusinessException 
	 */
	@PostMapping()
	Record addRecord(@PathVariable Long idAccount, @RequestBody Record record) throws BusinessException {
		return bankService.addRecordToAccount(idAccount, record);
	}
	/**
	 * return all records
	 * @param idAccount
	 * @throws BusinessException 
	 */
	@GetMapping("/records")
	List<Record> getRecords(@PathVariable Long idAccount) throws BusinessException {
		Account account = bankService.getAccount(idAccount).get();
		return bankService.getRecordsByAccountId(account);
	}

}
