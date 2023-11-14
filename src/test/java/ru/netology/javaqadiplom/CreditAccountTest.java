package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertFalse(account.add(-1));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNullBalance_Add() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );


        Assertions.assertFalse(account.add(0));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(2500);

        Assertions.assertEquals(-2500, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(6000));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNullBalance_Pay() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );


        Assertions.assertFalse(account.pay(0));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayFromPositiveBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        account.pay(500);

        Assertions.assertEquals(500, account.getBalance());

    }

    @Test
    public void yearChangeIfNegativeBalanceTest() {
        CreditAccount account = new CreditAccount(-200, 5000, 15);

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void yearChangeIfPositiveBalanceTest() {
        CreditAccount account = new CreditAccount(200, 5000, 15);

        Assertions.assertEquals(0, account.yearChange());
    }
}
