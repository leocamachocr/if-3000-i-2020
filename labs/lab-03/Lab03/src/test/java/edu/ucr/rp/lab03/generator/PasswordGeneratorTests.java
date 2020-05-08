package edu.ucr.rp.lab03.generator;

import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 *
 * @author leoca
 */
public class PasswordGeneratorTests {

    PasswordGeneratorBuilder builder = new PasswordGeneratorBuilder();

    @Before
    public void setup() {
        builder
                .withSpecialChars(new char[]{'#', '@', ')'})
                .withMinNumbers(1)
                .withMinLength(8)
                .withMinSpecialChars(1)
                .withMinUpperCase(1);
    }

    /**
     * Scenario: Generar un password con al menos 1 mayúscula
     *
     * - Given: Cantidad mínima de mayúscula -> Precondiciones
     *
     * - When: Generamos el password -> Acción a probar
     *
     * - Then: El password contiene al menos mayúscula -> Validaciones
     */
    @Test
    public void givenAnUppercaseAPasswordIsGenerated() {
        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();
        Assert.assertTrue("Invalid number of uppercase", getUpperCases(password) >= 1);

    }

    private long getUpperCases(String password) {
        //asde@$%f ->['a','s','d','e','@','$','%','f']

        return password.chars().filter(Character::isUpperCase).count();
    }

    /**
     * Scenario: Generar un password con al menos 1 caracter especial
     *
     * - Given: Cantidad mínima de un caracter especial
     *
     * - And: una lista de caracteres
     *
     * - When: Generamos el password
     *
     * - Then: El password contiene al menos un caracter especial de la lista de
     * caracteres
     */
    @Test
    public void givenAnSpecialCharAPasswordIsGenerated() {
        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();
        Assert.assertTrue("Invalid number of uppercase", getSpecialCases(password) >= 1);
        Assert.assertTrue("Invalid speacial char", containsSpecialChar(password, '#', '@', ')'));
        Assert.assertTrue("Invalid speacial char", getSpecialChar(password) > 0);

    }

    private long getSpecialCases(String password) {
        return password.chars().filter(it -> !Character.isLetter(it) && !Character.isDigit(it)).count();
    }

    private boolean containsSpecialChar(String password, Character... specialChars) {
        //"edre$%" ->[e,d,r,e,$,%]
        return password.chars()
                .filter(specialChar -> Stream.of(specialChars)
                .filter(param -> specialChar == param)
                .findAny().isPresent()).findAny().isPresent();

    }

    private long getSpecialChar(String password) {
        int count = 0;
        //{'@','&','#'}
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == '@'
                    || password.charAt(i) == ')'
                    || password.charAt(i) == '#') {
                count++;
            }
        }
        return count;
    }
}
