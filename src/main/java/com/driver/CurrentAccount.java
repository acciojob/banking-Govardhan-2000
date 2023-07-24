package com.driver;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // Minimum balance is 5000 by default. If the balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are the same.
        // If the license Id is valid, do nothing.
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                // Rearrange characters to create a valid license ID
                for (int j = i + 1; j < chars.length; j += 2) {
                    if (j < chars.length && chars[j] != chars[i]) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                }
            }
        }

        tradeLicenseId = new String(chars);
        // Check if the rearranged license ID is valid
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                throw new Exception("Valid License can not be generated");
            }
        }
    }
}
