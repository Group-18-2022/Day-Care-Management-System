package za.ac.cput.factory;

/* PrincipalFactoryTest.java
   Test for the Principal Factory
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Principal;
import za.ac.cput.factory.user.PrincipalFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PrincipalFactoryTest {
    private Principal principal;

    @BeforeEach
    void setUp() {
        principal = PrincipalFactory.createPrincipal("CR7", "Cristiano", "Ronaldo", "1985/08/05");
    }

    @Test
    void testCreationOfPrincipal() {
        assertAll(
                () -> assertNotNull(principal),
                () -> assertNotNull(principal.getPrincipalID()),
                () -> assertNotNull(principal.getFirstName()),
                () -> assertNotNull(principal.getLastName()),
                () -> assertNotNull(principal.getDob())
        );
    }

    @Test
    void testPrincipalIDForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PrincipalFactory.createPrincipal("", "Cristiano", "Ronaldo", "1985/08/05"));

        String expectedMessage = "Invalid value for principalID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testPrincipalIDForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PrincipalFactory.createPrincipal(null, "Cristiano", "Ronaldo", "1985/08/05"));

        String expectedMessage = "Invalid value for principalID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testInvalidPrincipalName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PrincipalFactory.createPrincipal("CR7", "", "Ronaldo", "1985/08/05"));

        String expectedMessage = "Invalid value for principalName.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
