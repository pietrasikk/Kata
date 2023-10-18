package org.kata.atm;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AtmList implements AtmInterface {

    private final List<Money> money;

    public AtmList(List<Money> money) {
        this.money = money;
    }

    @Override
    public List<Money> withdraw(int withdraw) {
        checkIfATMHasEnoughMoney(withdraw);

        List<Money> withdrawList = new ArrayList<>();
        Money bill500 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 500).findFirst().get();
        Money bill200 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 200).findFirst().get();
        Money bill100 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 100).findFirst().get();
        Money bill50 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 50).findFirst().get();
        Money bill20 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 20).findFirst().get();
        Money bill10 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 10).findFirst().get();
        Money bill5 = money.stream().filter(money -> money.getType().equals(Type.BILL) && money.getValue() == 5).findFirst().get();
        Money coin2 = money.stream().filter(money -> money.getType().equals(Type.COIN) && money.getValue() == 2).findFirst().get();
        Money coin1 = money.stream().filter(money -> money.getType().equals(Type.COIN) && money.getValue() == 1).findFirst().get();


        int tmpQuantity = withdraw;
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill500);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill200);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill100);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill50);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill20);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill10);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, bill5);
        tmpQuantity = checkAmountByNominal(tmpQuantity, withdrawList, coin2);
        checkAmountByNominal(tmpQuantity, withdrawList, coin1);
        return withdrawList;
    }

    private void checkIfATMHasEnoughMoney(int withdraw) {
        Map<Integer, IntSummaryStatistics> collect = money.stream()
                .collect(Collectors.groupingBy(Money::getValue, Collectors.summarizingInt(value -> value.getQuantity() * value.getValue())));
        if (withdraw > collect.values().stream().map(IntSummaryStatistics::getSum).mapToInt(Long::intValue).sum()) {
            throw new RuntimeException("The ATM machine has not enough money, please go to the nearest atm machine");
        }
    }

    private int checkAmountByNominal(int withdraw, List<Money> withdrawList, Money money) {
        int quantity = withdraw / money.getValue();
        int result = 0;
        if (money.getQuantity() >= quantity) {
            result = withdraw - (money.getValue() * quantity);
            withdrawList.add(new Money(money.getValue(), quantity, money.getType()));
        } else if (money.getQuantity() > 0 && money.getQuantity() < quantity) {
            result = withdraw - (money.getValue() * money.getQuantity());
            withdrawList.add(new Money(money.getValue(), money.getQuantity(), money.getType()));
        } else if (money.getQuantity() == 0) {
            result = withdraw;
        }
        return result;
    }
}
