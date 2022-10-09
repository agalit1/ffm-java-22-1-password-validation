import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationTest {

    String[] forbiddenPasswords = {
            "password",
            "123456789",
            "123456"
    };

    /*
    Password is valid when:
    - length is at least 8
    - contains at least one upper case character
    - contains at least one lower case character
    - contains at least one digit
    - contains at least one special character
    - is not contained in list of forbidden passwords

    Example valid password: aB1$aB1$
     */

    @Test
    public void passwordValid() {
        //given
        String password = "aB1$aB1$";

        //when
        boolean actual = Main.passwordIsValid(password);

        //then
        assertTrue(actual);
    }

    @Test
    public void passwordLengthInvalid() {
        //given
        String password = "aB1$aB1";

        //when
        boolean actual = Main.passwordIsValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    public void passwordContainsNumbersInvalid() {
        //given
        String password = "aBe$aBc$";

        //when
        boolean actual = Main.passwordIsValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    public void passwordContainsUpperCaseInvalid() {
        //given
        String password = "ab1$ab1$";

        //when
        boolean actual = Main.passwordIsValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    public void passwordContainsLowerCaseInvalid() {
        //given
        String password = "AB1$AB1$";

        //when
        boolean actual = Main.passwordIsValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    public void passwordContainsSpecialCharacterInvalid() {
        //given
        String password = "ab1uAb1i";

        //when
        boolean actual = Main.passwordIsValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    public void passwordForbiddenIsInvalid() {
        for (String invalidPassword : this.forbiddenPasswords) {
            boolean actual = Main.passwordIsValid(invalidPassword);
            assertFalse(actual);
        }
    }
}
