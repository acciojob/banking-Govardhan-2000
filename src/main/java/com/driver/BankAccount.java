package com.driver;

public class BankAccount {

    private String name;
    public double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
if(sum<0 || sum > 9 * digits ){
    throw new Exception("Account number can not be generated");
}
StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            if (sum >= 9) {
                accountNumber.append(9);
                sum -= 9;
            } else {
                accountNumber.append(sum);
                sum = 0;
            }
        }

        if (sum > 0) {
            throw new Exception("Account Number can not be generated");
        }

        return accountNumber.toString();

    }

    public void deposit(double amount) {
        //add amount to balance
        balance=balance+amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

}