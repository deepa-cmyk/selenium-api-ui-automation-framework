package com.test.web.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomGenerator {
    public static String generateRandomNumber(int length) {
        String number = "1234567890";
        StringBuilder randomNumber = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(number.length());
            randomNumber.append(number.charAt(index));
        }

        return randomNumber.toString();
    }

    private static int length = 10;

    // Method to generate a random word of a given length
    public static String generateRandomWord() {
        return RandomStringUtils.randomAlphabetic(length); // Generates a random alphabetic word
    }

    // Method to generate a random password of a given length
    public static String generateRandomPassword() {
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        // Combine all character sets
        String allChars = upperCaseChars + lowerCaseChars + digits + specialChars;

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        // Ensure the password contains at least one character from each set
        password.append(upperCaseChars.charAt(random.nextInt(upperCaseChars.length())));
        password.append(lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the rest of the password with random characters from all sets
        for (int i = password.length(); i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }
}
