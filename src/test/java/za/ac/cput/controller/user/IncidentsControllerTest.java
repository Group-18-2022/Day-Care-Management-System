package za.ac.cput.controller.user;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.factory.user.IncidentsFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IncidentsControllerTest {
    @LocalServerPort
    private int IncidentsPort;

    @Autowired
    private IncidentsController incidentsController;

    @Autowired
    private TestRestTemplate IncidentsRestTemp;
    private Incidents incidents;
    private  String IncidentsBaseUrl;

    @BeforeEach
    public void startUp(){
        assertNotNull(incidentsController);
        incidents = IncidentsFactory.build("incident-id","teacher-id","child-id","date","location","injury-description");
        this.IncidentsBaseUrl = "http://localhost:" + this.IncidentsPort + "api/v1/day-care/incidents/";

    }
    @Test
    @Order(1)
    void save() {
        String saveUrl = IncidentsBaseUrl + "save";
        ResponseEntity<Incidents> saveResponse = this.IncidentsRestTemp.
                postForEntity(saveUrl,this.incidents, Incidents.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String incidentsBaseUrl = IncidentsBaseUrl + "read/" + this.incidents.getIncidentID();
        ResponseEntity<Incidents> readResponse = this.IncidentsRestTemp.getForEntity(incidentsBaseUrl,Incidents.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotEquals(null,readResponse)
        );
    }


    @Test
    @Order(3)
    void deleteById() {
        String deleteByIdUrl = IncidentsBaseUrl + "delete/" + this.incidents.getIncidentID();
        this.IncidentsRestTemp.delete(deleteByIdUrl);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = IncidentsBaseUrl + "delete/";
        this.IncidentsRestTemp.delete(deleteUrl);
    }

    @Test
    @Order(5)
    void findAll() {
        String findAllUrl = IncidentsBaseUrl +"all";
        ResponseEntity<Incidents[]> findAllResponse = this.IncidentsRestTemp.
                getForEntity(findAllUrl,Incidents[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, findAllResponse.getStatusCode()),
                () -> assertNotNull(findAllResponse.getBody()),
                () -> assertTrue(findAllResponse.getBody().length == 0)

        );
    }

}