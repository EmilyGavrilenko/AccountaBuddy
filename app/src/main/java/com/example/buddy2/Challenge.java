package com.example.slohacks_2020;

public class Challenge
{
    public int challengeID;
    public String description;
    public double amount;
    public boolean won;    //keeps track of if the challenge was won or not
    public boolean status; //keeps track of if the challenge is active
    //deadline

    public Challenge(String description, double amount) //add deadline
    {
        this.description = description;
        this.amount = amount;
        this.status = true;  //default
    }
}
