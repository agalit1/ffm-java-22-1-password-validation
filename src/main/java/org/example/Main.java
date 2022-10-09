package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String userInput = String.valueOf(scan.nextLine());

        System.out.println(passwordIsValid(userInput));

    }

    public static boolean passwordIsValid(String password) {
        /*
        Password is valid when:
        - length is at least 8
        - contains at least one upper case character
        - contains at least one lower case character
        - contains at least one digit
        - contains at least one special character
        - is not contained in list of forbidden passwords

        Example valid password: aB1$aB1$
         */

        boolean isValid = passwordLengthValid(password)
                          && passwordHasDigit(password)
                          && passwordHasUpperCase(password)
                          && passwordHasLowerCase(password)
                          && passwordHasSpecialCharacter(password)
                          && passwordIsNotForbidden(password);
        return isValid;
    }

    private static boolean passwordLengthValid(String password) {
        return password.length() >= 8;
    }

    private static boolean passwordHasDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if ((Character.isDigit(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static boolean passwordHasUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if ((Character.isUpperCase(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static boolean passwordHasLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if ((Character.isLowerCase(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static boolean passwordHasSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isAlphabetic(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean passwordIsNotForbidden(String password) {
        String[] forbiddenPasswords = {
                "password",
                "123456789",
                "123456"
        };
        for (String forbiddenPassword : forbiddenPasswords) {
            if (forbiddenPassword.equals(password)) {
                return false;
            }
        }
        return true;
    }
}
