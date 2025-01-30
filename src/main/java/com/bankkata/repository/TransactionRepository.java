package com.bankkata.repository;

import com.bankkata.model.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public void addDeposit(int amount) {
        transactions.add(new Transaction(LocalDate.now(), amount));
    }

    public void addWithdrawal(int amount) {
        transactions.add(new Transaction(LocalDate.now(), -amount));
    }

    public List<Transaction> allTransactions() {
        return transactions;
    }
}
