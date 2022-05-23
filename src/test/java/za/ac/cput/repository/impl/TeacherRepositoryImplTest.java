package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.factory.user.IncidentsFactory;
import za.ac.cput.factory.user.TeacherFactory;
import za.ac.cput.repository.impl.user.IncidentsRepositoryImpl;
import za.ac.cput.repository.impl.user.TeacherRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class TeacherRepositoryImplTest {
    private TeacherRepositoryImpl repository;
    private Teacher teacher = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        teacher = TeacherFactory.build("13", "14", "Tom", "Harry", "12/02/2001");
        var teach = repository.create(teacher);
        assertAll(
                () -> assertNotNull(teach),
                () -> assertEquals(teacher.getTeacherID(), teach.getTeacherID()),
                () -> assertEquals(teacher.getClassNumber(), teach.getClassNumber()),
                () -> assertEquals(teacher.getFirstName(), teach.getFirstName()),
                () -> assertEquals(teacher.getLastName(), teach.getLastName()),
                () -> assertEquals(teacher.getDateOfBirth(), teach.getDateOfBirth())
        );
    }

    @Test
    void getRepository() {
        assertNotNull(repository);
    }

    @Test
    void read() {
        var teach = repository.read(teacher.getTeacherID());
        assertAll(
                () -> assertNotNull(teach),
                () -> assertEquals(teacher.getTeacherID(), teach.getTeacherID()),
                () -> assertEquals(teacher.getClassNumber(), teach.getClassNumber()),
                () -> assertEquals(teacher.getFirstName(), teach.getFirstName()),
                () -> assertEquals(teacher.getLastName(), teach.getLastName()),
                () -> assertEquals(teacher.getDateOfBirth(), teach.getDateOfBirth())
        );
    }

    @Test
    void update() {
        Teacher teach = new Teacher.Builder().copy(teacher).setDateOfBirth("12/03/2000").build();
        var updateTeacher = repository.update(teach);
        assertAll(
                () -> assertNotNull(updateTeacher),
                () -> assertEquals(teach.getTeacherID(), updateTeacher.getTeacherID()),
                () -> assertEquals(teach.getClassNumber(), updateTeacher.getClassNumber()),
                () -> assertEquals(teach.getFirstName(), updateTeacher.getFirstName()),
                () -> assertEquals(teach.getLastName(), updateTeacher.getLastName()),
                () -> assertEquals(teach.getDateOfBirth(), updateTeacher.getDateOfBirth())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(teacher.getTeacherID());
        assertTrue(isDeleted);
    }

    @Test
    void getTeacher() {
        assertEquals(1, repository.getTeacher().size());
    }

    @Test
    void contains() {
        var readTeachers = repository.read(teacher.getTeacherID());
        assertNotNull(readTeachers);
    }

}