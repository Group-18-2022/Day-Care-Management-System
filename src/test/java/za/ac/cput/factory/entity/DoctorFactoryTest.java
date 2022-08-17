package za.ac.cput.factory.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.factory.entity.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class DoctorFactoryTest {
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = DoctorFactory.buildDoctor(
                "1",
                "Healthy Clinic",
                "Peter",
                "Smith",
                "0825101207");
    }

    @Test
    void testDoctorCreation() {
        assertAll(
                () -> assertNotNull(doctor),
                () -> assertNotNull(doctor.getDoctorID()),
                () -> assertEquals("Healthy Clinic", doctor.getPracticeName()),
                () -> assertEquals("Peter", doctor.getFirstName()),
                () -> assertEquals("Smith", doctor.getLastName()),
                () -> assertEquals("0825101207", doctor.getPhoneNumber())
        );
    }

    @Test
    void testDoctorFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DoctorFactory.buildDoctor(null,null, null, null , null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDoctorFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DoctorFactory.buildDoctor("","", "", "" , "");
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}