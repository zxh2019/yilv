package com.train.week5.day2.homework;

public class Account {
    //账户id
    private int id;
    //账号
    private String accoutNo;
    //用户名
    private String userName;
    //密码
    private String password;
    //余额
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccoutNo() {
        return accoutNo;
    }

    public void setAccoutNo(String accoutNo) {
        this.accoutNo = accoutNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(int id, String accoutNo, String userName, String password, double balance) {
        this.id = id;
        this.accoutNo = accoutNo;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }
}


