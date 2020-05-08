/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucr.rp.lab03.generator;

/**
 * @author leoca
 */
public class PasswordGeneratorBuilder {

    private Integer minSpecialChars;
    private Integer minUpperCase;
    private Integer minNumbers;
    private Integer minLength;
    private char[] specialChars;

    public static PasswordGeneratorBuilder getInstance(){
        return new PasswordGeneratorBuilder();
    }

    public PasswordGeneratorBuilder withMinSpecialChars(Integer minSpecialChars) {
        this.minSpecialChars = minSpecialChars;
        return this;
    }

    public PasswordGeneratorBuilder withMinUpperCase(Integer minUpperCase) {
        this.minUpperCase = minUpperCase;
        return this;
    }

    public PasswordGeneratorBuilder withMinNumbers(Integer minNumbers) {
        this.minNumbers = minNumbers;
        return this;
    }

    public PasswordGeneratorBuilder withMinLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    public PasswordGeneratorBuilder withSpecialChars(char...specialChars) {
        this.specialChars = specialChars;
        return this;
    }

    public PasswordGenerator build() {
        return new PasswordGenerator(minSpecialChars,
                minUpperCase,
                minNumbers,
                minLength,
                specialChars);
    }

}
