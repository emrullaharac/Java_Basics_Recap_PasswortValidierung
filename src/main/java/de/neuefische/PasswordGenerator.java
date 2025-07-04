package de.neuefische;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;


    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private PasswordGenerator() {
        // Utility class, soll nicht instanziert werden.
        throw new UnsupportedOperationException("Utility class");
    }

    public static String generatePassword(int length) {
        if (length < 8) {
            return ("Length must be equal or greater than 8");
        }
        List<Character> passwordChars = new ArrayList<>();
        // Jeweils ein Zeichen aus jeder Zeichenklasse hinzufügen
        passwordChars.add(UPPERCASE.charAt(SECURE_RANDOM.nextInt(UPPERCASE.length())));
        passwordChars.add(LOWERCASE.charAt(SECURE_RANDOM.nextInt(LOWERCASE.length())));
        passwordChars.add(DIGITS.charAt(SECURE_RANDOM.nextInt(DIGITS.length())));
        passwordChars.add(SPECIAL_CHARACTERS.charAt(SECURE_RANDOM.nextInt(SPECIAL_CHARACTERS.length())));

        // Restliche Zeichen zufällig aus dem gesamten Zeichenvorrat hinzufügen
        for (int i = 4; i < length; i++) {
            passwordChars.add(ALL_CHARACTERS.charAt(SECURE_RANDOM.nextInt(ALL_CHARACTERS.length())));
        }

        // Zeichenliste mischen, damit die Reihenfolge zufällig ist
        Collections.shuffle(passwordChars, SECURE_RANDOM);

        // Liste in einen String umwandeln und zurückgeben
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }
        return password.toString();
    }
}
