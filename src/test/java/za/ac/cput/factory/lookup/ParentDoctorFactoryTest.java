package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.lookup.ParentDoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class ParentDoctorFactoryTest {
    private ParentDoctor parentDoctor;

    @BeforeEach
    void setUp() {
        parentDoctor = ParentDoctorFactory.buildParentDoctor("1", "1");
    }

    @Test
    void testParentDoctorFactoryCreation() {
        assertAll(
                () -> assertEquals("1", parentDoctor.getDoctorID()),
                () -> assertEquals("1", parentDoctor.getParentID())
        );
    }

    @Test
    void testParentDoctorFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParentDoctorFactory.buildParentDoctor(null, null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testParentDoctorFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParentDoctorFactory.buildParentDoctor("", "");
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}