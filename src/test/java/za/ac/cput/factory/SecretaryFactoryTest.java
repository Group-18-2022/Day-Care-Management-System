package za.ac.cput.factory;

/* SecretaryFactoryTest.java
   Test for the Secretary Factory
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Secretary;
import za.ac.cput.factory.user.SecretaryFactory;

import static org.junit.jupiter.api.Assertions.*;

public class SecretaryFactoryTest {
    private Secretary secretary;

    @BeforeEach
    void setUp() {
        secretary = SecretaryFactory.createSecretary("CR7", "Cristiano", "Ronaldo", "1985/08/05");
    }

    @Test
    void testCreationOfSecretary() {
        assertAll(
                () -> assertNotNull(secretary),
                () -> assertNotNull(secretary.getSecretaryID()),
                () -> assertNotNull(secretary.getFirstName()),
                () -> assertNotNull(secretary.getLastName()),
                () -> assertNotNull(secretary.getDob())
        );
    }

    @Test
    void testSecretaryIDForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SecretaryFactory.createSecretary("", "Cristiano", "Ronaldo", "1985/08/05"));

        String expectedMessage = "Invalid value for secretaryID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testSecretaryIDForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SecretaryFactory.createSecretary(null, "Cristiano", "Ronaldo", "1985/08/05"));

        String expectedMessage = "Invalid value for secretaryID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testInvalidSecretaryName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SecretaryFactory.createSecretary("CR7", "", "Ronaldo", "1985/08/05"));

        String expectedMessage = "Invalid value for secretaryName.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
