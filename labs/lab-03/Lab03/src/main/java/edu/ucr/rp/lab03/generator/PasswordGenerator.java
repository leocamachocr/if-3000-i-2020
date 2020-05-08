package edu.ucr.rp.lab03.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author leoca
 */
public class PasswordGenerator {

    private Integer minSpecialChars;
    private Integer minUpperCase;
    private Integer minNumbers;
    private Integer minLength;
    private char[] specialChars;

    private static final Random RANDOM = new Random();
    private static final char[] LETTERS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private enum CharType {
        LOWER,
        UPPER,
        SPECIAL,
        NUMBER
    }


    public PasswordGenerator(Integer minSpecialChars,
                             Integer minUpperCase,
                             Integer minNumbers,
                             Integer minLength,
                             char[] specialChars) {
        this.minSpecialChars = minSpecialChars;
        this.minUpperCase = minUpperCase;
        this.minNumbers = minNumbers;
        this.minLength = minLength;
        this.specialChars = specialChars;
    }

    public String generate() {
        List<CharType> passwordTemplate = new ArrayList();
        addCharTypes(passwordTemplate, CharType.UPPER, minUpperCase);
        addCharTypes(passwordTemplate, CharType.NUMBER, minNumbers);
        addCharTypes(passwordTemplate, CharType.SPECIAL, minSpecialChars);
        if (passwordTemplate.size() < minLength) {
            addCharTypes(passwordTemplate, CharType.LOWER, minLength - passwordTemplate.size());

        }
        return shuffleAndGet(passwordTemplate);
    }

    private String shuffleAndGet(List<CharType> passwordTemplate) {

        StringBuilder pass = new StringBuilder();
        while (passwordTemplate.size() > 0) {
            int id = RANDOM.nextInt(passwordTemplate.size());
            switch (passwordTemplate.get(id)) {
                case UPPER:
                    pass.append(randomUpper());
                    break;
                case SPECIAL:
                    pass.append(randomSpecialChar());
                    break;
                case NUMBER:
                    pass.append(randomNumber());
                    break;
                case LOWER:
                    pass.append(randomLower());
                    break;
            }
            passwordTemplate.remove(id);

        }
        return pass.toString();
    }


    private void addCharTypes(List<CharType> passwordTemplate, CharType type, Integer minChars) {
        IntStream.range(0, minChars).forEach(i -> passwordTemplate.add(type));
    }

    private char randomSpecialChar() {
        return specialChars[RANDOM.nextInt(specialChars.length)];
    }

    private String randomNumber() {
        return String.valueOf(RANDOM.nextInt(10));
    }

    private char randomLower() {
        return LETTERS[RANDOM.nextInt(LETTERS.length)];
    }

    private char randomUpper() {
        return Character.toUpperCase(randomLower());
    }
}
