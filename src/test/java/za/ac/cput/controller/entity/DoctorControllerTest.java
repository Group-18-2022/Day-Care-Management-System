package za.ac.cput.controller.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.factory.entity.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoctorControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private DoctorController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Doctor doctor;
    private String doctorBaseURL;


    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.doctor = DoctorFactory.buildDoctor("1", "Test Practice Name", "Tester", "Test Last Name", "0897654321");
        this.doctorBaseURL = "http://localhost:" + this.port + "/api/v1/day-care/doctor/";
        System.out.println(doctorBaseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = doctorBaseURL + "save";
        ResponseEntity<Doctor> response = this.restTemplate
            .withBasicAuth("Test User", "123456")
            .postForEntity(
                url, this.doctor, Doctor.class
            );
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = doctorBaseURL + "read/" + doctor.getDoctorID();
        ResponseEntity<Doctor> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .getForEntity(url, Doctor.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(5)
    void delete() {
        String url = doctorBaseURL + "delete";
        this.restTemplate.withBasicAuth("Test User", "123456").delete(url);
    }

    @Test
    @Order(3)
    void deleteById() {
        String url = doctorBaseURL + "delete/" + this.doctor.getDoctorID();
        this.restTemplate.withBasicAuth("Test User", "123456").delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = doctorBaseURL + "all";
        ResponseEntity<Doctor[]> response = this.restTemplate
                .withBasicAuth("Test User", "123456")
                .getForEntity(url, Doctor[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}