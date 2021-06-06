package com.example.accountapp.logic;

import com.example.accountapp.ui.OutputInterface;

import java.util.Date;

/**
 * This file defines the Account class.  It provides the basis for a
 * series of improvements you'll need to make as you progress through
 * the lessons in Module 6.
 */
public class Account {
    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * </p>
     * This was renamed to 'mOut' from 'out', as it is in the video
     * lessons, to better match Android/Java naming guidelines.
     */

    OutputInterface mOut;

    /**
     * Constructor initializes the field
     */
    public Account(OutputInterface out) {
        mOut = out;
    }

    /**
     * Name of the account holder.
     */
    private String name;

    /**
     * Number of the account.
     */
    private String number;

    /**
     * Current balance in the account.
     */
    private double balance;
    private static int count=0;


    // Important note on constructors...
    // Each constructor that you add should take an OutputInterface parameter that
    // is used to initialize mOut (similar to the constuctor above).
    // Please remember to add that parameter to the code that you see in the lectures.

    public Account(String Name){
        name=Name;
        number=buildAcctNumber();
    }

    private String buildAcctNumber() {
        count = (count+1) % 100;
        String s=String.valueOf(count);
        return(formatYear() + hash(this.name) + s);
    }

    private String hash(String name) {
        int i=Integer.parseInt(name);
        String s=String.valueOf(i);
        return s;
    }

    private String formatYear() {
        Date d=new Date();
        int year=d.getYear();
        String si=String.valueOf(year % 100);
        return si;
    }

    public Account(String Name, double initialBalance){
       this(Name);
       balance=initialBalance;
    }
    public String getName(){
        return (name);
    }
    public String getNumber(){
        return (number);
    }
    public double getBalance(){
        return (balance);
    }
    public void setName(String nm){
        name=nm;
    }
//    public void setNumber(int nm){
//        number=nm;
//    }

    /**
     * Deposit @a amount into the account.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw @a amount from the account.  Prints "Insufficient
     * Funds" if there's not enough money in the account.
     */
    public boolean withdrawal(double amount) {
        if (balance > amount) {
            balance -= amount;
            return true;
        }
        else
            return false;
            //mOut.println("Insufficient Funds");
    }

    /**
     * Display the current @a amount in the account.
     */
    public void displayBalance() {
        mOut.println("The balance on account "+ number + " is " + balance);
    }
}
