package de.neuefische;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {8, 12, 16})
    void generatePassword_shouldMeetAllCriteria(int length) {
        String password = PasswordGenerator.generatePassword(length);
        assertEquals(length, password.length(), "Falsche Passwortlänge");
        assertTrue(PasswordValidator.containsLetters(password), "Kein Großbuchstabe");
        assertTrue(PasswordValidator.containsNumbers(password), "Keine Ziffer");
        assertTrue(PasswordValidator.containsSpecialCharacter(password), "Kein Sonderzeichen");
        assertFalse(PasswordValidator.isCommonPassword(password), "Passwort ist ein häufig verwendetes Passwort");
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 12, 16})
    void generatePassword_shouldBeValidAccordingToIsValidPassword(int length) {
        String password = PasswordGenerator.generatePassword(length);
        assertTrue(PasswordValidator.isValidPassword(password), "Das generierte Passwort erfüllt nicht alle Validierungskriterien.");
    }
}