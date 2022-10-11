package za.ac.cput.service.user.Impl;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.factory.user.TeacherFactory;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeacherServiceImplTest {

    private Teacher teacher;

    @Autowired
    private TeacherServiceImpl teacherService;

    @BeforeEach
    public void startUp(){
        this.teacher = TeacherFactory.build("teacher-id","class-number","first-name","last-name","date-of-birth");
    }

    @Test
    @Order(1)
    void save() {
        Teacher saveTeacher = this.teacherService.save(teacher);
        assertEquals(this.teacher, saveTeacher);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Teacher> readTeacher = this.teacherService.read(teacher.getTeacherID());
        assertAll(
                () -> assertTrue(readTeacher.isPresent()),
                () -> assertEquals(teacher, readTeacher.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.teacherService.delete(this.teacher);
        findAll();
    }


    void findAll(){
        List<Teacher> teacherList = this.teacherService.findAll();
        assertEquals(0, teacherList.size());
    }
    @Test
    @Order(3)
    void deleteById() {
        this.teacherService.deleteById(teacher.getTeacherID());
        findAll();
    }


}