package za.ac.cput.controller.lookup;

/* ESPControllerTest.java
   Controller Test Cases for ESP
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.factory.lookup.ESPFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ESPControllerTest {

    @LocalServerPort
    private int localPort;
    @Autowired
    private ESPController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private EmergencyServiceProvider esp;
    private String baseURL;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.esp = ESPFactory.createESP("some-id", "Health", "Medical", "911");
        this.baseURL = "http://localhost:" + this.localPort+ "/api/v1/day-care-system/esp/";
        System.out.println(baseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<EmergencyServiceProvider> response = this.restTemplate.
                postForEntity(url,this.esp, EmergencyServiceProvider.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "read/" + this.esp.getServiceID();
        ResponseEntity<EmergencyServiceProvider> response = this.restTemplate.getForEntity(url,EmergencyServiceProvider.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseURL + "delete/";
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void deleteById() {
        String url = baseURL + "delete/" + this.esp.getServiceID();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void findAll() {
        String url = baseURL +"all";
        ResponseEntity<EmergencyServiceProvider[]> response = this.restTemplate.getForEntity(url,EmergencyServiceProvider[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
}