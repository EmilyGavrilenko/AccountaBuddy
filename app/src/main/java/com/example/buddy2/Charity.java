package com.example.buddy2;

public class Charity
{
    public String name;
    //logo
    public String description;
    public BankAccount bankAccount;

    public Charity(String name, String description) //add logo
    {
        this.name = name;
        this.description = description;
        this.bankAccount = new BankAccount(0);
    }

    public double getAmountRaised()
    {
        return bankAccount.getBalance();
    }

}