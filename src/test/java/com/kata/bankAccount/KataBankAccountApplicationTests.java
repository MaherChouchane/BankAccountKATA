package com.kata.bankAccount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kata.bankAccount.entity.Record;
import com.kata.bankAccount.entity.RecordType;
import com.kata.bankAccount.exception.BusinessException;
import com.kata.bankAccount.repository.AccountRepository;
import com.kata.bankAccount.repository.RecordRepository;
import com.kata.bankAccount.service.BankService;

@RunWith(MockitoJUnitRunner.class)
public class KataBankAccountApplicationTests {

	@InjectMocks
	BankService bankService;
	@Mock
	AccountRepository accountRepository;
	@Mock
	RecordRepository recordRepository;

	@Test
	public void should_deposit_works_correctly() throws BusinessException {
		float balance = 15000;
		Record record = new Record();
		record.setAmount(10000);
		record.setType(RecordType.DEPOSIT);
		assertThat(bankService.calculateBalance(balance, record)).isEqualTo(25000);
	}

	@Test
	public void should_withdrawal_works_correctly() throws BusinessException {
		float balance = 15000;
		Record record = new Record();
		record.setAmount(10000);
		record.setType(RecordType.WITHDRAWAL);
		assertThat(bankService.calculateBalance(balance, record)).isEqualTo(5000);
	}

	@Test
	public void should_throw_exception_when_withdrawal_amount_more_than_balance() throws BusinessException {
		// given
		float balance = 15000;
		Record record = new Record();
		record.setAmount(100000);
		record.setType(RecordType.WITHDRAWAL);

		// expect
		Throwable thrown = catchThrowable(() -> {
			bankService.calculateBalance(balance, record);
		});

		// when
		assertThat(thrown).isInstanceOf(BusinessException.class);
	}

	@Test
	public void should_throw_exception_when_account_not_found() throws BusinessException {
		// given
		long id = 2;
		when(accountRepository.findById(id)).thenReturn(null);

		// expect
		Throwable thrown = catchThrowable(() -> {
			bankService.getAccount(id);
		});

		// when
		assertThat(thrown).isInstanceOf(BusinessException.class);
	}

}
