package com.bankkata.service;

import com.bankkata.model.Transaction;
import java.util.List;

public class StatementPrinter {
    public void print(List<Transaction> transactions) {
        System.out.println("DATE       | AMOUNT  | BALANCE");
        int balance = 0;

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            balance += transaction.getAmount();
            System.out.printf("%s | %7d | %7d\n",
                    transaction.getDate(),
                    transaction.getAmount(),
                    balance
            );
        }
    }

}
