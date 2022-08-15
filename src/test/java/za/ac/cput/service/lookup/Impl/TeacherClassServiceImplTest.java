package za.ac.cput.service.lookup.Impl;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.factory.lookup.TeacherClassFactory;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeacherClassServiceImplTest {

    private TeacherClass teacherClass;

    @Autowired
    private TeacherClassServiceImpl teacherClassService;

    @BeforeEach
    public void startUp(){
        this.teacherClass = TeacherClassFactory.build("teacher-id","room-id");
    }

    @Test
    @Order(1)
    void save() {
        TeacherClass saveTeacherClass = this.teacherClassService.save(teacherClass);
        assertEquals(this.teacherClass, saveTeacherClass);
    }

    @Test
    @Order(2)
    void read() {
        Optional<TeacherClass> readTeacherClass = this.teacherClassService.read(teacherClass.getTeacherID());
        assertAll(
                () -> assertTrue(readTeacherClass.isPresent()),
                () -> assertEquals(teacherClass, readTeacherClass.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.teacherClassService.delete(this.teacherClass);
        findAll();
    }


    void findAll(){
        List<TeacherClass> teacherClassList = this.teacherClassService.findAll();
        assertEquals(0, teacherClassList.size());
    }
    @Test
    @Order(3)
    void deleteById() {
        this.teacherClassService.deleteById(teacherClass.getTeacherID());
        findAll();
    }

}