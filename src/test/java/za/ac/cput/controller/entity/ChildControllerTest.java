package za.ac.cput.controller.entity;
/**
 *
 * This is the Child Controller test
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.Child;
import za.ac.cput.factory.entity.ChildFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChildControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ChildController controller;

    @Autowired
    private TestRestTemplate restTemp;

    private Child child;
    private String childURL;

    @BeforeEach
    void startUp(){
        assertNotNull(controller);
        this.child = ChildFactory.createChild("1","James","Olson","12 Beans Street",
                "09/05/2017","Male");
        this.childURL =   "/api/v1/day-care/child/";
    }
    @Test
    @Order(1)
    void save() {
        String url = childURL + "save";
        ResponseEntity<Child> saveResponse = this.restTemp.postForEntity(
                url, this.child, Child.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = childURL + "read/" + this.child.getChildID();
        ResponseEntity<Child> readResponse = this.restTemp.getForEntity(url, Child.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotNull(readResponse.getBody())
        );
    }

    @Test
    @Order(3)
    void deleteById() {
        String url = childURL + "delete/" + this.child.getChildID();
        this.restTemp.delete(url);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = childURL + "delete";
        this.restTemp.delete(deleteUrl);
    }


    @Test
    @Order(5)
    void findAll() {
        String url = childURL + "all";
        ResponseEntity<Child[]> response = this.restTemp
                .getForEntity(url, Child[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}