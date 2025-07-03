package de.neuefische;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

public class PasswordValidator {
    private static final Set<String> COMMON_PASSWORDS = loadCommonPasswords();

    private PasswordValidator() {
        // Utility class, soll nicht instanziert werden.
        throw new UnsupportedOperationException("Utility class");
    }

    private static Set<String> loadCommonPasswords() {
        try (InputStream in = PasswordValidator.class.getResourceAsStream("/200_most_used_passwords.txt")) {
            assert in != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                return reader.lines()
                        .map(String::trim)
                        .filter(line -> !line.isEmpty())
                        .collect(Collectors.toSet());
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Could not load common passwords file", e);
        }
    }

    /**
     * Prüft, ob das gegebene Passwort alle Sicherheitskriterien erfüllt.
     */
    public static boolean isValidPassword(String password) {
        return checkLength(password) && containsNumbers(password) && containsLetters(password) && !isCommonPassword(password);
    }

    /**
     * Prüft, ob das Passwort mindestens 8 Zeichen lang ist.
     */
    public static boolean checkLength(String password) {
        return password.length() >= 8;
    }

    /**
     * Prüft, ob das Passwort mindestens eine Ziffer enthält.
     */
    public static boolean containsNumbers(String password) {
        return password.matches(".*\\d.*");
    }

    /**
     * Prüft, ob das Passwort sowohl Groß- als auch Kleinbuchstaben enthält.
     */
    public static boolean containsLetters(String password) {
        return containsLowercase(password) && containsUppercase(password);
    }


    /**
     * Prüft, ob das Passwort mindestens einen Kleinbuchstaben enthält.
     */
    private static boolean containsLowercase(String password) {
        return password.matches(".*\\p{Ll}.*");
    }


    /**
     * Prüft, ob das Passwort mindestens einen Großbuchstaben enthält.
     */
    private static boolean containsUppercase(String password) {
        return password.matches(".*\\p{Lu}.*");
    }

    /**
     * Prüft, ob das Passwort mindestens ein Sonderzeichen enthält.
     */
    public static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    /**
     * Prüft, ob das Passwort zu den häufig verwendeten Passwörtern gehört.
     */
    public static boolean isCommonPassword(String password) {
        return COMMON_PASSWORDS.contains(password);
    }
}
