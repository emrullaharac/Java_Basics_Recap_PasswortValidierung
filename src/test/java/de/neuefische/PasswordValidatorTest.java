package de.neuefische;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

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