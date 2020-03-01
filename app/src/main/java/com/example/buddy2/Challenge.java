package com.example.buddy2;


import java.util.Date;

public class Challenge
{
    public String challengeID;
    public String description;
    public double amount;
    public boolean won;    //keeps track of if the challenge was won or not
    public boolean status; //keeps track of if the challenge is active
    public Date deadlibe;
    //deadline

    public Challenge(String challengeID, String description, double amount) //add deadline
    {
        this.challengeID = challengeID;
        this.description = description;
        this.amount = amount;
        this.status = true;  //default
    }
    public Challenge(){
        this.status = true;  //default
    }
}
