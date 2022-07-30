package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.factory.entity.DoctorFactory;
import za.ac.cput.factory.user.IncidentsFactory;

import static org.junit.jupiter.api.Assertions.*;

class IncidentsFactoryTest {
    private Incidents incidents;

    @BeforeEach
    void setUp() {
        incidents = IncidentsFactory.build("12", "13", "14", "12/2/22","Cape Town", "Broken Finger");
    }

    @Test
    void testIncidentsWithSuccess() {
        assertAll(
                () -> assertNotNull(incidents),
                () -> assertNotNull(incidents.getIncidentID()),
                () -> assertEquals("14", incidents.getTeacherID()),
                () -> assertEquals("14", incidents.getChildID()),
                () -> assertEquals("12/2/22", incidents.getDate()),
                () -> assertEquals("Cape Town", incidents.getLocation()),
                () -> assertEquals("Broken Finger", incidents.getInjuryDescription())
        );
    }

    @Test
    void testIncidentsWithErrors() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            IncidentsFactory.build(null, null, null , null, null, null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}