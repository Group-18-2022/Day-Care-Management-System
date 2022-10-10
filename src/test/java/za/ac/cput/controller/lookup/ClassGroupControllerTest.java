package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.Child;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.factory.lookup.ClassGroupFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClassGroupControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ClassGroupController controller;

    @Autowired
    private TestRestTemplate restTemp;

    private ClassGroup classGroup;
    private String classGroupURL;

    @BeforeEach
    void startUp(){
        this.classGroup = ClassGroupFactory.createClassGroup("1",25,true);
        this.classGroupURL = "http://localhost:" + this.port + "/api/v1/day-care/classgroup/";
    }

    @Test
    @Order(1)
    void save() {
        String url = classGroupURL + "save";
        ResponseEntity<ClassGroup> saveResponse = this.restTemp.postForEntity(
                url, this.classGroupURL, ClassGroup.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = classGroupURL + "read/" + this.classGroup.getClassID();
        ResponseEntity<ClassGroup> readResponse = this.restTemp.getForEntity(url, ClassGroup.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotNull(readResponse.getBody())
        );
    }

    @Test
    @Order(5)
    void delete() {
        String deleteUrl = classGroupURL + "delete";
        this.restTemp.delete(deleteUrl);
    }

    @Test
    @Order(4)
    void deleteById() {
        String url = classGroupURL + "delete/" + this.classGroup.getClassID();
        this.restTemp.delete(url);
    }

    @Test
    @Order(6)
    void findAll() {
        String url = classGroupURL + "all";
        ResponseEntity<ClassGroup[]> response = this.restTemp
                .getForEntity(url,ClassGroup[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}