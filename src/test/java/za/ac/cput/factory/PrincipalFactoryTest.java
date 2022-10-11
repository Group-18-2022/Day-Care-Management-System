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
        principal = PrincipalFactory.createPrincipal("Joshua", "Jonkers", "05/08/1996");
    }

    @Test
    void createPrincipal() {
        assertNotNull(principal);
    }

    @Test
    void testFirstName() {
        assertEquals("Joshua", principal.getFirstName());
    }

    @Test
    void testLastName() {
        assertEquals("Jonkers", principal.getLastName());
    }

    @Test
    void testDod() {
        assertEquals("05/08/1996", principal.getDob());
    }
}
