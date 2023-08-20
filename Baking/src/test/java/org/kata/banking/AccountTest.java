package org.kata.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AccountTest {

    Account account;

    @BeforeEach
    public void setup() {
        account = new Account(new ArrayList<>(), 0);
    }

    @Test
    void shouldIncreaseAmount_whenInvokeDeposit() {
        int deposit = 500;
        account.deposit(deposit);
        account.printStatement();
    }

    @Test
    void shouldDecreaseAmount_whenInvokeWithdrawal() {
        int withdrawal = 500;
        account.withdrawal(withdrawal);
        account.printStatement();
    }

    @Test
    void shouldPrintAllResults_whenInvokePrintStatement() {
        account.deposit(1000);
        account.withdrawal(100);
        account.deposit(500);
        account.printStatement();
    }
}
