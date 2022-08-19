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
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.factory.user.TeacherFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeacherControllerTest {
    @LocalServerPort
    private int TeacherPort;

    @Autowired
    private TeacherController teacherController;

    @Autowired
    private TestRestTemplate TeacherRestTemp;
    private Teacher teacher;
    private  String TeacherBaseUrl;

    @BeforeEach
    public void startUp(){
        assertNotNull(teacherController);
        teacher = TeacherFactory.build("teacher-id","class-number","first-name","last-name","date-of-birth");
        this.TeacherBaseUrl = "http://localhost:" + this.TeacherPort + "api/v1/day-care/teacher/";

    }
    @Test
    @Order(1)
    void save() {
        String saveUrl = TeacherBaseUrl + "save";
        ResponseEntity<Teacher> saveResponse = this.TeacherRestTemp.
                postForEntity(saveUrl,this.teacher, Teacher.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String teacherBaseUrl = TeacherBaseUrl + "read/" + this.teacher.getTeacherID();
        ResponseEntity<Teacher> readResponse = this.TeacherRestTemp.getForEntity(teacherBaseUrl,Teacher.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotEquals(null,readResponse)
        );
    }


    @Test
    @Order(3)
    void deleteById() {
        String deleteByIdUrl = TeacherBaseUrl + "delete/" + this.teacher.getTeacherID();
        this.TeacherRestTemp.delete(deleteByIdUrl);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = TeacherBaseUrl + "delete/";
        this.TeacherRestTemp.delete(deleteUrl);
    }

    @Test
    @Order(5)
    void findAll() {
        String findAllUrl = TeacherBaseUrl +"all";
        ResponseEntity<Teacher[]> findAllResponse = this.TeacherRestTemp.
                getForEntity(findAllUrl,Teacher[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, findAllResponse.getStatusCode()),
                () -> assertNotNull(findAllResponse.getBody()),
                () -> assertTrue(findAllResponse.getBody().length == 0)

        );
    }

}