package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(6_000, account.getBalance());
    }


    @Test
    public void shouldPayFromPositiveBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        account.pay(500);

        Assertions.assertEquals(500, account.getBalance());

    }
}