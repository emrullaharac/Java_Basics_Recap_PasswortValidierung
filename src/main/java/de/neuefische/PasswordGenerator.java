package de.neuefische;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    private static final String ALL_CHARACTERS =
            UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private PasswordGenerator() {
        // Utility class, soll nicht instanziert werden.
        throw new UnsupportedOperationException("Utility class");
    }
}
