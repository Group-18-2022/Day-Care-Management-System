package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Driver;

import za.ac.cput.factory.user.DriverFactory;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DriverFactoryTest {
    private Driver driver;

    @BeforeEach
    void setUp() {
        driver= DriverFactory.createDriver("111","Lutho", "Majoka", "Code-8" );
    }

    @Test
    void testDriverId() {
        assertAll(
                () -> assertNotNull(driver),
                () -> assertNotNull(driver.idNumber()),
                () -> assertEquals("111", driver.getIdNumber())
        );
    }

    @Test
    void testFirstNameForForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> DriverFactory.createDriver("111", "Lutho", "Majoka", "Code-10"));

        String expectedMessage = "Invalid value for Driver name.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
