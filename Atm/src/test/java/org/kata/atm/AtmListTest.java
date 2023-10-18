package org.kata.atm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AtmListTest {

    @Test
    void shouldWithdrawMoney_whenWithdraw434Euro() {
        List<Money> atmMoney = List.of(
                new Money(500, 10, Type.BILL),
                new Money(200, 10, Type.BILL),
                new Money(100, 10, Type.BILL),
                new Money(50, 10, Type.BILL),
                new Money(20, 10, Type.BILL),
                new Money(10, 10, Type.BILL),
                new Money(5, 10, Type.BILL),
                new Money(2, 10, Type.COIN),
                new Money(1, 10, Type.COIN)
        );
        AtmInterface atm = new AtmList(atmMoney);
        List<Money> withdraw = atm.withdraw(434);
        assertNotEquals(null, withdraw);
        int quantity200 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 200).map(Money::getQuantity).findFirst().get();
        int quantity20 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 20).map(Money::getQuantity).findFirst().get();
        int quantity10 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 10).map(Money::getQuantity).findFirst().get();
        int quantity2 = withdraw.stream().filter(money -> money.getType().equals(Type.COIN) && money.getValue() == 2).map(Money::getQuantity).findFirst().get();
        assertEquals(2, quantity200);
        assertEquals(1, quantity20);
        assertEquals(1, quantity10);
        assertEquals(2, quantity2);
        System.out.println(withdraw);
    }

    @Test
    void shouldWithdrawMoneyWithDifferentValue_whenWithdraw434EuroAndAtmDoesNotHave200() {
        List<Money> atmMoney = List.of(
                new Money(500, 10, Type.BILL),
                new Money(200, 0, Type.BILL),
                new Money(100, 10, Type.BILL),
                new Money(50, 10, Type.BILL),
                new Money(20, 10, Type.BILL),
                new Money(10, 10, Type.BILL),
                new Money(5, 10, Type.BILL),
                new Money(2, 10, Type.COIN),
                new Money(1, 10, Type.COIN)
        );
        AtmInterface atm = new AtmList(atmMoney);
        List<Money> withdraw = atm.withdraw(434);
        assertNotEquals(null, withdraw);
        int quantity200 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 200).map(Money::getQuantity).findFirst().orElse(0);
        int quantity100 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 100).map(Money::getQuantity).findFirst().orElse(0);
        int quantity20 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 20).map(Money::getQuantity).findFirst().get();
        int quantity10 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 10).map(Money::getQuantity).findFirst().get();
        int quantity2 = withdraw.stream().filter(money -> money.getType().equals(Type.COIN) && money.getValue() == 2).map(Money::getQuantity).findFirst().get();
        assertEquals(0, quantity200);
        assertEquals(4, quantity100);
        assertEquals(1, quantity20);
        assertEquals(1, quantity10);
        assertEquals(2, quantity2);
        System.out.println(withdraw);
    }


    @Test
    void shouldWithdrawMoney_whenWithdraw1725Euro() {
        List<Money> atmMoney = List.of(
                new Money(500, 2, Type.BILL),
                new Money(200, 3, Type.BILL),
                new Money(100, 5, Type.BILL),
                new Money(50, 12, Type.BILL),
                new Money(20, 20, Type.BILL),
                new Money(10, 50, Type.BILL),
                new Money(5, 100, Type.BILL),
                new Money(2, 250, Type.COIN),
                new Money(1, 500, Type.COIN)
        );
        AtmInterface atm = new AtmList(atmMoney);
        List<Money> withdraw = atm.withdraw(1725);
        assertNotEquals(null, withdraw);
        int quantity500 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 500).map(Money::getQuantity).findFirst().get();
        int quantity200 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 200).map(Money::getQuantity).findFirst().get();
        int quantity100 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 100).map(Money::getQuantity).findFirst().get();
        int quantity20 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 20).map(Money::getQuantity).findFirst().get();
        int quantity5 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 5).map(Money::getQuantity).findFirst().get();
        assertEquals(2, quantity500);
        assertEquals(3, quantity200);
        assertEquals(1, quantity100);
        assertEquals(1, quantity20);
        assertEquals(1, quantity5);
        System.out.println(withdraw);
    }

    @Test
    void shouldWithdrawMoney_whenWithdraw1825Euro() {
        List<Money> atmMoney = List.of(
                new Money(500, 0, Type.BILL),
                new Money(200, 0, Type.BILL),
                new Money(100, 4, Type.BILL),
                new Money(50, 12, Type.BILL),
                new Money(20, 19, Type.BILL),
                new Money(10, 50, Type.BILL),
                new Money(5, 99, Type.BILL),
                new Money(2, 250, Type.COIN),
                new Money(1, 500, Type.COIN)
        );
        AtmInterface atm = new AtmList(atmMoney);
        List<Money> withdraw = atm.withdraw(1825);
        assertNotEquals(null, withdraw);
        int quantity100 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 100).map(Money::getQuantity).findFirst().get();
        int quantity50 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 50).map(Money::getQuantity).findFirst().get();
        int quantity20 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 20).map(Money::getQuantity).findFirst().get();
        int quantity10 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 10).map(Money::getQuantity).findFirst().get();
        int quantity5 = withdraw.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 5).map(Money::getQuantity).findFirst().get();
        assertEquals(4, quantity100);
        assertEquals(12, quantity50);
        assertEquals(19, quantity20);
        assertEquals(44, quantity10);
        assertEquals(1, quantity5);
        System.out.println(withdraw);
    }

    @Test
    void shouldThrowException_whenWithdrawMoreManThanAtmHas() {
        List<Money> atmMoney = List.of(
                new Money(500, 10, Type.BILL),
                new Money(200, 10, Type.BILL),
                new Money(100, 10, Type.BILL),
                new Money(50, 10, Type.BILL),
                new Money(20, 10, Type.BILL),
                new Money(10, 10, Type.BILL),
                new Money(5, 10, Type.BILL),
                new Money(2, 10, Type.COIN),
                new Money(1, 10, Type.COIN)
        );
        AtmInterface atm = new AtmList(atmMoney);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> atm.withdraw(10000));
        assertEquals("The ATM machine has not enough money, please go to the nearest atm machine", exception.getMessage());
    }
}
