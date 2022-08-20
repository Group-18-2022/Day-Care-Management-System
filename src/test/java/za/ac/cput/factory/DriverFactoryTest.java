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
        driver= DriverFactory.createDriver("Majoka","Lutho", "Code 8");
    }

    @Test
    void testDriverId() {
        assertAll(
                () -> assertNotNull(driver),
                () -> assertNotNull(driver.idNumber()),
                () -> assertEquals("1999", driver.getIdNumber())
        );
    }

    @Test
    void testFirstNameForForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DriverFactory.buildDriver(null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}
