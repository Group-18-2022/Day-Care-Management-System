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
        secretary = SecretaryFactory.createSecretary("Chandre", "de Kock", "27/10/1994");
    }

    @Test
    void createSecretary() {
        assertNotNull(secretary);
    }

    @Test
    void testFirstName() {
        assertEquals("Chandre", secretary.getFirstName());
    }

    @Test
    void testLastName() {
        assertEquals("de Kock", secretary.getLastName());
    }

    @Test
    void testDod() {
        assertEquals("27/10/1994", secretary.getDob());
    }
}
