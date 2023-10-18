package org.kata.atm;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AtmMap implements AtmInterface {

    private final Map<Integer, Money> money;

    public AtmMap(Map<Integer, Money> money) {
        this.money = money;
    }

    @Override
    public List<Money> withdraw(int withdraw) {
        checkIfATMHasEnoughMoney(withdraw);
        print("Before: ", money);
        List<Money> withdrawList = new ArrayList<>();
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(500), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(200), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(100), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(50), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(20), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(10), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(5), money);
        withdraw = checkAmountByNominal(withdraw, withdrawList, money.get(2), money);
        checkAmountByNominal(withdraw, withdrawList, money.get(1), money);
        print("After: ", money);
        return withdrawList;
    }

    private void print(String string, Map<Integer, Money> money) {
        System.out.println(string);
        money.values().stream().forEach(System.out::println);
    }

    private void checkIfATMHasEnoughMoney(int withdraw) {
        Map<Integer, IntSummaryStatistics> collect = money.values().stream()
                .collect(Collectors.groupingBy(Money::getValue, Collectors.summarizingInt(value -> value.getQuantity() * value.getValue())));
        if (withdraw > collect.values().stream().map(IntSummaryStatistics::getSum).mapToInt(Long::intValue).sum()) {
            throw new RuntimeException("The ATM machine has not enough money, please go to the nearest atm machine");
        }
    }

    private int checkAmountByNominal(int withdraw, List<Money> withdrawList, Money money, Map<Integer, Money> atmMoney) {
        int quantity = withdraw / money.getValue();
        int result = 0;
        if (money.getQuantity() >= quantity) {
            result = withdraw - (money.getValue() * quantity);
            withdrawList.add(new Money(money.getValue(), quantity, money.getType()));
            atmMoney.replace(money.getValue(), new Money(money.getValue(), (money.getQuantity() - quantity), money.getType()));
        } else if (money.getQuantity() > 0 && money.getQuantity() < quantity) {
            result = withdraw - (money.getValue() * money.getQuantity());
            withdrawList.add(new Money(money.getValue(), money.getQuantity(), money.getType()));
            atmMoney.replace(money.getValue(), new Money(money.getValue(), (money.getQuantity() - money.getQuantity()), money.getType()));
        } else if (money.getQuantity() == 0) {
            result = withdraw;
        }
        return result;
    }
}
