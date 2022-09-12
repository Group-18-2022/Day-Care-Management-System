package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.entity.DoctorFactory;
import za.ac.cput.factory.entity.ParentFactory;
import za.ac.cput.factory.lookup.ParentDoctorFactory;
import za.ac.cput.service.entity.impl.DoctorServiceImpl;
import za.ac.cput.service.entity.impl.ParentServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParentDoctorControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private ParentDoctorController controller;
    @Autowired private TestRestTemplate restTemplate;
    @Autowired private DoctorServiceImpl doctorService;
    @Autowired private ParentServiceImpl parentService;

    private ParentDoctor parentDoctor;
    private String parentDoctorBaseURL;


    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.parentDoctor = ParentDoctorFactory.buildParentDoctor("1", "1");
        this.parentDoctorBaseURL = "http://localhost:" + this.port + "/api/v1/day-care/parent-doctor/";
        System.out.println(parentDoctorBaseURL);
        AddParentAndDoctorToDB();
    }

    void AddParentAndDoctorToDB() {
        var doctor = DoctorFactory.buildDoctor("1", "Test Practice Name", "Tester", "Test Last Name", "0897654321");
        var parent = ParentFactory.buildParent("test-id", "Tester", "Tester Last Name", "123 Test Street", "0987654321");
        doctorService.save(doctor);
        parentService.save(parent);
    }

    @Test
    @Order(1)
    void save() {
        String url = parentDoctorBaseURL + "save";
        ResponseEntity<ParentDoctor> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .postForEntity(
                url, this.parentDoctor, ParentDoctor.class
                );
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = parentDoctorBaseURL + "read/" + parentDoctor.getParentID();
        ResponseEntity<ParentDoctor> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .getForEntity(url, ParentDoctor.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = parentDoctorBaseURL + "delete";
        this.restTemplate.withBasicAuth("Test User", "123456").delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = parentDoctorBaseURL + "all";
        ResponseEntity<ParentDoctor[]> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .getForEntity(url, ParentDoctor[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}