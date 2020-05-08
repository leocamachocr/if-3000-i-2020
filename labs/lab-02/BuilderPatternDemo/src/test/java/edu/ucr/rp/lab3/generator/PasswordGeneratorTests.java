package edu.ucr.rp.lab3.generator;

import edu.ucr.rp.lab03.generator.PasswordGeneratorBuilder;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Password Generator Tests")
public class PasswordGeneratorTests {

    private PasswordGeneratorBuilder builder;

    @BeforeEach
    public void setup() {
        builder = new PasswordGeneratorBuilder()
                .withMinLength(10)
                .withMinNumbers(1)
                .withMinSpecialChars(1)
                .withMinUpperCase(1)
                .withSpecialChars('#', '%', '@');
    }


    @Tag("basic")//optional
    @DisplayName("Given 1 uppercase param when password is generated then should have 1 uppercase")// optional
    @Test // required
    public void testOneUpperCase() {
        String password = builder.withMinUpperCase(1).build().generate();
        assertEquals(getUpperCases(password), 1, "Invalid number of uppercase");
    }

    @Disabled
    @Tag("basic")//optional
    @DisplayName("Given 0 uppercase param when password is generated then should have 0 uppercase")// optional
    @Test // required
    public void testZeroUpperCase() {
        String password = builder.withMinUpperCase(0).build().generate();
        assertEquals(getUpperCases(password), 0, "Invalid number of uppercase");
    }

    @Tag("basic")//optional
    @DisplayName("Given 1 char by type as param when password is generated then should have 1 char by type")// optional
    @Test // required
    public void testPasswordCombination() {
        String password = builder.withMinUpperCase(1)
                .withMinNumbers(1)
                .withMinSpecialChars(1)
                .withSpecialChars('#').build().generate();
        assertAll("Password should have one char by type",
                () -> assertEquals(getUpperCases(password), 1, "Invalid number of uppercase"),
                () -> assertEquals(getNumberCases(password), 1, "Invalid number of numbers"),
                () -> assertEquals(getSpecialCases(password), 1, "Invalid number of special chars")
        );

    }


    private long getUpperCases(String password) {
        return password.chars().filter(Character::isUpperCase).count();
    }

    private long getNumberCases(String password) {
        return password.chars().filter(Character::isDigit).count();
    }

    private long getSpecialCases(String password) {
        return password.chars().filter(it -> !Character.isLetter(it) && !Character.isDigit(it)).count();
    }
}
