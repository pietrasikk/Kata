package org.kata.banking;

import java.time.LocalDate;
import java.util.List;

class Account {
    private final List<AccountEntry> entry;
    private int balance;

    public Account(List<AccountEntry> entry, int balance) {
        this.entry = entry;
        this.balance = balance;
    }

    public void deposit(int deposit) {
        balance += deposit;
        entry.add(new AccountEntry(LocalDate.now().toString(), deposit, balance));
    }

    public void withdrawal(int withdrawal) {
        balance -= withdrawal;
        entry.add(new AccountEntry(LocalDate.now().toString(), withdrawal, balance));
    }

    public void printStatement() {
        System.out.println("DATE\t| AMOUNT\t| BALANCE");
        for (int iterator = entry.size() - 1; iterator >= 0; iterator--) {
            System.out.println(entry.get(iterator).getDate() + "\t| " + entry.get(iterator).getAmount() + "\t| " + entry.get(iterator).getBalance());
        }
    }

    static class AccountEntry {
        private String date;
        private int amount;
        private int balance;

        public AccountEntry(String date, int amount, int balance) {
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }

        public String getDate() {
            return date;
        }

        public int getAmount() {
            return amount;
        }

        public int getBalance() {
            return balance;
        }
    }
}
