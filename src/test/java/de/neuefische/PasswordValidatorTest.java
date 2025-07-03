package de.neuefische;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            // Mindestens 8 Zeichen, enthält Groß- und Kleinbuchstaben, Zahlen und Sonderzeichen, kein Common Password
            "G!ut3nT@g2024",
            "S1cher#Passw0rt",
            "ZxCvB!12$%",
            "J@vaR0cks2025",
            "Mein_B3stes*PW"
    })
    void isValidPassword_shouldReturnTrue_WhenPasswordIsValid(String password) {
        assertTrue(PasswordValidator.isValidPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "password",    // häufig verwendetes Passwort, enthält nur Kleinbuchstaben, keine Zahl, kein Sonderzeichen
            "12345678",    // häufig verwendetes Passwort, enthält nur Zahlen
            "ABCDEFGH",    // nur Großbuchstaben, keine Zahl, kein Kleinbuchstabe
            "abcdefg1",    // kein Großbuchstabe
            "Abcdefg",     // keine Zahl
            "Pass1",       // weniger als 8 Zeichen
    })
    void isValidPassword_shouldReturnFalse_WhenPasswordIsNOTValid(String password) {
        assertFalse(PasswordValidator.isValidPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefgh", "abcd1234", "passwort123"})
    void checkLength_shouldReturnTrue_WhenPasswordLengthIsAtLeastEight(String testPassword) {
        assertTrue(PasswordValidator.checkLength(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1234567", ""})
    void checkLength_shouldReturnFalse_WhenPasswordLengthIsLessThanEight(String testPassword) {
        assertFalse(PasswordValidator.checkLength(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"passwort1", "123456", "abc123"})
    void containsNumber_shouldReturnTrue_WhenPasswordContainsNumber(String testPassword) {
        assertTrue(PasswordValidator.containsNumbers(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcdefg1", "aB123456", "JAVAjava", "TestTest", "ZxCvBnM8"})
    void containsLetter_shouldReturnTrue_WhenPasswordContainsLetter(String testPassword) {
        assertTrue(PasswordValidator.containsLetters(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "!@#$%^&*", "9876543210", "1234!@#%", ""})
    void containsLetter_shouldReturnFalse_WhenPasswordNotContainsLowerOrUpper(String testPassword) {
        assertFalse(PasswordValidator.containsLetters(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456",
            "password",
            "qwerty",
            "princess",
            "letmein",
            "football",
            "monkey",
            "loveme",
            "sunshine",
            "password123"
    })
    void isCommonPassword_shouldReturnTrue_WhenPasswordIsCommon(String testPassword) {
        assertTrue(PasswordValidator.isCommonPassword(testPassword));
    }
}