package za.ac.cput.controller.lookup;

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
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.factory.lookup.TeacherClassFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeacherClassControllerTest {
    @LocalServerPort
    private int TeacherClassPort;

    @Autowired
    private TeacherClassController teacherClassController;

    @Autowired
    private TestRestTemplate TeacherClassRestTemp;
    private TeacherClass teacherClass;
    private  String TeacherClassBaseUrl;

    @BeforeEach
    public void startUp(){
        assertNotNull(teacherClassController);
        teacherClass = TeacherClassFactory.build("teacher-id","room-id");
        this.TeacherClassBaseUrl = "http://localhost:" + this.TeacherClassPort + "api/v1/day-care/teacher-class/";

    }
    @Test
    @Order(1)
    void save() {
        String saveUrl = TeacherClassBaseUrl + "save";
        ResponseEntity<TeacherClass> saveResponse = this.TeacherClassRestTemp.
                postForEntity(saveUrl,this.teacherClass, TeacherClass.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String teacherClassBaseUrl = TeacherClassBaseUrl + "read/" + this.teacherClass.getTeacherID();
        ResponseEntity<TeacherClass> readResponse = this.TeacherClassRestTemp.getForEntity(teacherClassBaseUrl,TeacherClass.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotEquals(null,readResponse)
        );
    }


    @Test
    @Order(3)
    void deleteById() {
        String deleteByIdUrl = TeacherClassBaseUrl + "delete/" + this.teacherClass.getTeacherID();
        this.TeacherClassRestTemp.delete(deleteByIdUrl);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = TeacherClassBaseUrl + "delete/";
        this.TeacherClassRestTemp.delete(deleteUrl);
    }

    @Test
    @Order(5)
    void findAll() {
        String findAllUrl = TeacherClassBaseUrl +"all";
        ResponseEntity<TeacherClass[]> findAllResponse = this.TeacherClassRestTemp.
                getForEntity(findAllUrl,TeacherClass[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, findAllResponse.getStatusCode()),
                () -> assertNotNull(findAllResponse.getBody()),
                () -> assertTrue(findAllResponse.getBody().length == 0)

        );
    }

}