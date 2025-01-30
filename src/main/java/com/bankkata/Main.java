package com.bankkata;


import com.bankkata.repository.TransactionRepository;
import com.bankkata.service.Account;
import com.bankkata.service.StatementPrinter;

public class Main {
    public static void main(String[] args) {
        TransactionRepository transactionRepository = new TransactionRepository();
        StatementPrinter statementPrinter = new StatementPrinter();
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();
    }
}