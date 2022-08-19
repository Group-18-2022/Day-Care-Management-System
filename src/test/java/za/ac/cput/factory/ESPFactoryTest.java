package za.ac.cput.factory;

/* ESPFactoryTest.java
   Test for the Emergency Service Provider Factory
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.factory.lookup.ESPFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ESPFactoryTest {
    private EmergencyServiceProvider esp;

    @BeforeEach
    void setUp() {
        esp = ESPFactory.createESP("some-id", "Health", "Medical", "911");
    }

    @Test
    void testCreationOfESP() {
        assertAll(
                () -> assertNotNull(esp),
                () -> assertNotNull(esp.getServiceID()),
                () -> assertNotNull(esp.getServiceName()),
                () -> assertNotNull(esp.getType()),
                () -> assertNotNull(esp.getPhoneNum())
        );
    }

    @Test
    void testESPIDForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ESPFactory.createESP("", "Health", "Medical", "911"));

        String expectedMessage = "Invalid value for serviceID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testESPIDForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ESPFactory.createESP(null, "Health", "Medical", "911"));

        String expectedMessage = "Invalid value for serviceID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testInvalidESPName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ESPFactory.createESP("some-id", "", "Medical", "911"));

        String expectedMessage = "Invalid value for serviceName.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
