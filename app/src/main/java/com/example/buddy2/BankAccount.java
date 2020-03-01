package com.example.buddy2;

public class BankAccount
{
    private double balance;

    public BankAccount() {}

    public BankAccount(double amount)
    {
        balance = amount;
    }

    public void setBalance(double amount)
    {
        balance = amount;
    }

    public double getBalance()
    {
        return ((int)balance*100)/100.0;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

}