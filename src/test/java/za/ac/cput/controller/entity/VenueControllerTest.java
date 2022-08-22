package za.ac.cput.controller.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.entity.DayCareVenue;
import za.ac.cput.domain.lookup.GroupRoom;
import za.ac.cput.factory.entity.ClassRoomFactory;
import za.ac.cput.factory.entity.DayCareVenueFactory;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VenueControllerTest
{
    @LocalServerPort
    private int port;
    @Autowired
    private VenueController controller;
    @Autowired private TestRestTemplate restTemplate;

    private DayCareVenue venue;
    private String baseURL;



    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.venue = DayCareVenueFactory.build("Sparks Creche", "10 Angel Lane", "0000", "01");
        this.baseURL = "http://localhost:" + this.port + "/api/v1/day-care/venue/";
        System.out.println(baseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<DayCareVenue> response = this.restTemplate.postForEntity(
                url, this.controller, DayCareVenue.class
        );
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "read/" + venue.getDayCareName();
        ResponseEntity<DayCareVenue> response = this.restTemplate.getForEntity(url, DayCareVenue.class);
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
        String url = baseURL + "delete/" + this.venue.getDayCareName();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<DayCareVenue[]> response = this.restTemplate.getForEntity(url, DayCareVenue[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}