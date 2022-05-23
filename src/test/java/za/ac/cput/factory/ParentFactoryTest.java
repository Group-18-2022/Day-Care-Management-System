package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.factory.entity.ParentFactory;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */
class ParentFactoryTest {
    private Parent parent;

    @BeforeEach
    void setUp() {
        parent = new ParentFactory().buildParent("John", "Smith", "12 Bell Street", "012 345 6540");
    }

    @Test
    void testParentFactoryCreation() {
        assertAll(
                () -> assertNotNull(parent),
                () -> assertNotNull(parent.getParentID()),
                () -> assertEquals("John", parent.getFirstName()),
                () -> assertEquals("Smith", parent.getLastName()),
                () -> assertEquals("12 Bell Street", parent.getAddress()),
                () -> assertEquals("012 345 6540", parent.getPhoneNumber())
        );
    }

    @Test
    void testParentFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParentFactory.buildParent(null, null, null, null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testParentFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParentFactory.buildParent("", "", "", "");
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}