package com.example.buddy2;

public class Transaction
{
    public static void donate(User sender, Charity receiver, double amount)
    {
        sender.bankAccount.withdraw(amount);
        sender.moneyDonated += amount;
        receiver.bankAccount.deposit(amount);
    }
}
