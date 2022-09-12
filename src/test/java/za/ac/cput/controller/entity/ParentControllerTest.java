package za.ac.cput.controller.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.factory.entity.ParentFactory;

import static org.junit.jupiter.api.Assertions.*;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private ParentController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Parent parent;
    private String parentBaseURL;


    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.parent = ParentFactory.buildParent("test-id", "Tester", "Tester Last Name", "123 Test Street", "0987654321");
        this.parentBaseURL = "http://localhost:" + this.port + "/api/v1/day-care/parent/";
        System.out.println(parentBaseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = parentBaseURL + "save";
        ResponseEntity<Parent> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .postForEntity(
                url, this.parent, Parent.class
                );
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = parentBaseURL + "read/" + parent.getParentID();
        ResponseEntity<Parent> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .getForEntity(url, Parent.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(5)
    void delete() {
        String url = parentBaseURL + "delete";
        this.restTemplate.withBasicAuth("Test User", "123456").delete(url);
    }

    @Test
    @Order(3)
    void deleteById() {
        String url = parentBaseURL + "delete/" + this.parent.getParentID();
        this.restTemplate.withBasicAuth("Test User", "123456").delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = parentBaseURL + "all";
        ResponseEntity<Parent[]> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .getForEntity(url, Parent[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}