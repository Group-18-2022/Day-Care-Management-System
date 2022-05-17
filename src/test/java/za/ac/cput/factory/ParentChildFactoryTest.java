package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.factory.lookup.ParentChildFactory;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class ParentChildFactoryTest {
    private ParentChild parentChild;

    @BeforeEach
    void setUp() {
        parentChild = new ParentChildFactory().buildParentChild("1", "1");
    }

    @Test
    void testParentChildFactory() {
        assertAll(
                () -> assertNotNull(parentChild),
                () -> assertNotNull(parentChild.getParentID()),
                () -> assertNotNull(parentChild.getChildID()),
                () -> assertEquals("1", parentChild.getParentID()),
                () -> assertEquals("1", parentChild.getChildID())
        );
    }

    @Test
    void testParentChildFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParentChildFactory.buildParentChild(null, null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testParentChildFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParentChildFactory.buildParentChild("", "");
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}