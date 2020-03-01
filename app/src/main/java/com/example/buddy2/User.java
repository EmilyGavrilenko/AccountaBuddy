package com.example.buddy2;

import java.util.ArrayList;
import java.util.List;

public class User
{
    public String username;
    //profile photo
    public List<Challenge> pastChallenges;
    public List<Challenge> currentChallenges;
    public List<User> friends;
    public List<User> friendRequests;
    //public List<String> notifications;
    public BankAccount bankAccount;
    public Charity charity;
    public double moneyDonated;

    public User(String username)
    {
        this.username = username;
        pastChallenges = new ArrayList<>();
        currentChallenges = new ArrayList<>();
        friends = new ArrayList<>();
        friendRequests = new ArrayList<>();
        moneyDonated = 0;
    }

    public void setUsername(String newname)
    {
        username = newname;
    }

    //public void setProfilePhoto()

    public void setCharity(Charity charity)
    {
        this.charity = charity;
    }

    public void setBankAccount(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    public void createBankAccount()
    {
        BankAccount bank = new BankAccount(0);
        bankAccount = bank;
    }

    public double getMoneyDonated()
    {
        return moneyDonated;
    }

    public void newChallenge(String description, double amount)
    {
        Challenge challenge = new Challenge(description, amount); // add deadline
        currentChallenges.add(challenge);
    }

    public void completeChallenge(Challenge challenge, boolean outcome)
    {
        challenge.won = outcome;
        challenge.status = false;

        if (!challenge.won)
        {
            Transaction.donate(this, this.charity, challenge.amount);
        }

        for (Challenge c : currentChallenges)
        {
            if (c.equals(challenge))
            {
                currentChallenges.remove(challenge);
            }
        }
        pastChallenges.add(challenge);

        //add notification
    }

    // friendship
    public void sendFriendRequest(User user)
    {
        user.friendRequests.add(user);
        //add notification
    }

    public void acceptFriend(User friend)
    {
        this.friendRequests.remove(friend);
        this.friends.add(friend);
        friend.friends.add(this);
        //notify other user
    }

    public void denyFriendRequest(User user)
    {
        this.friendRequests.remove(user);
        //notify other user?
    }

    public void removeFriend(User user)
    //throws NullPointerException
    {
        if(friends.contains(user))
        {
            this.friends.remove(user);
            user.friends.remove(this);
        }
        else
        {
            System.out.println("Error : user not found in this.friends :could not remove user from this.friends");
            //throw NullPointerException;
        }
    }
}
