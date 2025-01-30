package com.bankkata;

import com.bankkata.model.Transaction;
import com.bankkata.service.Account;
import com.bankkata.service.StatementPrinter;
import com.bankkata.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {
    private Account account;
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    @BeforeEach
    public void setup() {
        transactionRepository = mock(TransactionRepository.class);
        statementPrinter = mock(StatementPrinter.class);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void should_print_statement_containing_all_transactions() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();

        verify(transactionRepository).addDeposit(1000);
        verify(transactionRepository).addDeposit(2000);
        verify(transactionRepository).addWithdrawal(500);
        verify(statementPrinter).print(anyList());
    }

    @Test
    public void should_print_transactions_in_correct_order() {
        Transaction t1 = new Transaction(LocalDate.of(2012, 1, 10), 1000);
        Transaction t2 = new Transaction(LocalDate.of(2012, 1, 13), 2000);
        Transaction t3 = new Transaction(LocalDate.of(2012, 1, 14), -500);

        List<Transaction> transactions = List.of(t1, t2, t3);
        when(transactionRepository.allTransactions()).thenReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
    

}
