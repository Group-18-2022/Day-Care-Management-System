package za.ac.cput.controller.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.factory.entity.ClassRoomFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClassRoomControllerTest
{
    @LocalServerPort
    private int port;
    @Autowired
    private ClassRoomController controller;
    @Autowired private TestRestTemplate restTemplate;

    private ClassRoom room;
    private String baseURL;



    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.room = ClassRoomFactory.build("12", "g07");
        this.baseURL = "http://localhost:" + this.port + "/api/v1/day-care/classroom/";
        System.out.println(baseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<Doctor> response = this.restTemplate.postForEntity(
                url, this.controller, Doctor.class
        );
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "read/" + room.getOccupancy();
        ResponseEntity<ClassRoom> response = this.restTemplate.getForEntity(url, ClassRoom.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(5)
    void delete() {
        String url = baseURL + "delete";
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void deleteById() {
        String url = baseURL + "delete/" + this.room.getOccupancy();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<ClassRoom[]> response = this.restTemplate.getForEntity(url, ClassRoom[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}