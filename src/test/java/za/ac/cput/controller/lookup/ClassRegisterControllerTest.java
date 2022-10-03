package za.ac.cput.controller.lookup;

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
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.factory.lookup.ClassGroupFactory;
import za.ac.cput.factory.lookup.ClassRegisterFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClassRegisterControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ClassRegisterController controller;

    @Autowired
    private TestRestTemplate restTemp;

    private ClassRegister classRegister;
    private String classRegisterURL;

    @BeforeEach
    void startUp(){
        this.classRegister= ClassRegisterFactory.createClassRegister("1","1","1","1","12/10/2022",25);
        this.classRegisterURL = "http://localhost:" + this.port + "/api/v1/day-care/classregister/";
    }
    @Test
    void save() {
        String url = classRegisterURL + "save";
        ResponseEntity<ClassRegister> saveResponse = this.restTemp.postForEntity(
                url, this.classRegisterURL, ClassRegister.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    void read() {
        String url = classRegisterURL + "read/" + this.classRegister.getRosterID();
        ResponseEntity<ClassRegister> readResponse = this.restTemp.getForEntity(url, ClassRegister.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotNull(readResponse.getBody())
        );
    }

    @Test
    void delete() {
        String deleteUrl = classRegisterURL + "delete";
        this.restTemp.delete(deleteUrl);
    }

    @Test
    void deleteById() {
        String url = classRegisterURL + "delete/" + this.classRegister.getRosterID();
        this.restTemp.delete(url);
    }

    @Test
    void findAll() {
        String url = classRegisterURL + "all";
        ResponseEntity<ClassRegister[]> response = this.restTemp
                .getForEntity(url,ClassRegister[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}