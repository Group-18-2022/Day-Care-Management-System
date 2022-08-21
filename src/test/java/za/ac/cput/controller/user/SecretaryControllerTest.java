package za.ac.cput.controller.user;

/* SecretaryControllerTest.java
   Controller Test Cases for Secretary
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
import za.ac.cput.controller.lookup.ESPController;
import za.ac.cput.domain.user.Secretary;
import za.ac.cput.factory.user.SecretaryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SecretaryControllerTest {

    @LocalServerPort
    private int localPort;
    @Autowired
    private ESPController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private Secretary secretary;
    private String baseURL;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.secretary = SecretaryFactory.createSecretary("JR11", "Neymar", "Junior", "1992/08/05");
        this.baseURL = "http://localhost:" + this.localPort+ "/api/v1/day-care-system/secretary/";
        System.out.println(baseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<Secretary> response = this.restTemplate.
                postForEntity(url,this.secretary, Secretary.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "read/" + this.secretary.getSecretaryID();
        ResponseEntity<Secretary> response = this.restTemplate.getForEntity(url,Secretary.class);
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
        String url = baseURL + "delete/" + this.secretary.getSecretaryID();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void findAll() {
        String url = baseURL +"all";
        ResponseEntity<Secretary[]> response = this.restTemplate.getForEntity(url,Secretary[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
}