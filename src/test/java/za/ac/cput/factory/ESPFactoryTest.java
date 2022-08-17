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
        esp = ESPFactory.createESP("Medical assistance", "Medical", "072 146 0715");
    }

    @Test
    void createESP() {
        assertNotNull(esp);
    }

    @Test
    void testServiceName() {
        assertEquals("Medical assistance", esp.getServiceName());
    }

    @Test
    void testType() {
        assertEquals("Medical", esp.getType());
    }

    @Test
    void testPhoneNum() {
        assertEquals("072 146 0715", esp.getPhoneNum());
    }
}
