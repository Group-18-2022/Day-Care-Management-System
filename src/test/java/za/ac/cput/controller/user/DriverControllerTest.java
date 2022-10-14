package za.ac.cput.controller.user;

/*
   Mponeng Ratego
   216178991
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.Driver;
import za.ac.cput.factory.user.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DriverControllerTest {
    @LocalServerPort
    private int driverPort;
    @Autowired
    private DriverController driverController;
    @Autowired
    private TestRestTemplate restTemplate;

    private Driver driver;
    private String DriverbaseURL;

    @BeforeEach
    void setUp() {
        assertNotNull(driverController);
        this.driver = DriverFactory.createDriver("111", "Lwando", "Joka", "Code-10");
        this.DriverbaseURL = "http://localhost:" + this.driverPort+ "/api/v1/day-care-system/driver/";
        System.out.println(DriverbaseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = DriverbaseURL + "save";
        ResponseEntity<Driver> response = this.restTemplate.
                postForEntity(url,this.driver, Driver.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = DriverbaseURL + "read/" + this.driver.getIdNumber();
        ResponseEntity<Driver> response = this.restTemplate.getForEntity(url,Driver.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = DriverbaseURL + "delete/";
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void deleteById() {
        String url = DriverbaseURL + "delete/" + this.driver.getIdNumber();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void findAll() {
        String url = DriverbaseURL +"all";
        ResponseEntity<Driver[]> response = this.restTemplate.getForEntity(url,Driver[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

}
