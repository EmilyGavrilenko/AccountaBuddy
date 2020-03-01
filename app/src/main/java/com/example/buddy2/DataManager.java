package com.example.buddy2;

import java.util.List;
import java.util.ArrayList;

public class DataManager
{
    public static List<Charity> charities;

    public static String challenge1desc = "Get to Class on Time";
    public static double challenge1amount = 5.00;
    public static String challenge1deadline = "Monday, March 2nd";

    public static String challenge2desc;
    public static double challenge2amount;
    public static String challenge2deadline;

    public static String challenge3desc;
    public static double challenge3amount;
    public static String challenge3deadline;

    public static void doData() //add this to the launch operations
    {
        challenge1desc = "No challenge Yet";
        challenge2desc = "No challenge Yet";
        challenge3desc = "No challenge Yet";

        challenge1amount = 0;
        challenge2amount = 0;
        challenge3amount = 0;

        challenge1deadline = "";
        challenge2deadline = "";
        challenge3deadline = "";

        charities = new ArrayList<>();
        generateCharities();
    }

    public static void generateCharities() //update to get charity info from database
    {
//        String c1_name = "American Red Cross";
//        String c1_desc = "A humanitarian organization that provides emergency assistance, disaster relief, and disaster preparedness education in the United States.";
//        double c1_bal  = 0;
//        charities.add(new Charity(c1_name, c1_desc, c1_bal));
//
//        String c2_name = "The Salvation Army";
//        String c2_desc = "The Salvation Army exists to meet human need without discrimination to directly benefits those in need throughout your local community.";
//        double c2_bal = 0;
//        charities.add(new Charity(c2_name, c2_desc, c2_bal));
//
//        String c3_name = "Habitat for Humanity";
//        String c3_desc = "A nonprofit organization that helps families build and improve places to call home. We believe affordable housing plays a critical role in strong and stable communities.";
//        double c3_bal = 0;
//        charities.add(new Charity(c3_name, c3_desc, c3_bal));
//
//        String c4_name = "4Ocean";
//        String c4_desc = "This organization works to clean the ocean and coastlines while working to stop the inflow of plastic by changing consumption habits.";
//        double c4_bal = 0;
//        charities.add(new Charity(c4_name, c4_desc, c4_bal));
//
//        String c5_name = "The Nature Conservancy";
//        String c5_desc = "The Nature Conservancy is a global environmental nonprofit working to create a world where people and nature can thrive through various conservation efforts.";
//        double c5_bal = 0;
//        charities.add(new Charity(c5_name, c5_desc, c5_bal));
//
//        String c6_name = "Feeding America";
//        String c6_desc = "A United States–based nonprofit organization that feeds more than 46 million people through food pantries, soup kitchens, shelters, and other community-based agencies.";
//        double c6_bal = 0;
//        charities.add(new Charity(c6_name, c6_desc, c6_bal));
    }

    public static void addChallenge(String description, double amount, String deadline)
    {
        if(challenge1amount == 0)
        {
            challenge1desc = description;
            challenge1amount = amount;
            challenge1deadline = deadline;
        }
        else if (challenge2amount == 0)
        {
            challenge2desc = description;
            challenge2amount = amount;
            challenge2deadline = deadline;
        }
        else if(challenge3amount == 0)
        {
            challenge3desc = description;
            challenge3amount = amount;
            challenge3deadline = deadline;
        }
        else
        {
            //donothing
        }

    }

}