package za.ac.cput.repository.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.factory.lookup.ParentChildFactory;
import za.ac.cput.factory.lookup.TeacherClassFactory;
import za.ac.cput.repository.impl.lookup.ParentChildRepositoryImpl;
import za.ac.cput.repository.impl.lookup.TeacherClassRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class TeacherClassRepositoryImplTest {
    private TeacherClassRepositoryImpl repository;
    private TeacherClass teacherClass = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        teacherClass = TeacherClassFactory.build("1", "1");
        var teachClass = repository.create(teacherClass);
        assertAll(
                () -> assertNotNull(teacherClass)
        );
    }

    @AfterEach
    void tearDown() {
        var teacherClassDB = repository.getAllTeacherClass();
        teacherClassDB.removeAll(teacherClassDB);
    }

    @Test
    void getRepository() { assertNotNull(repository); }

    @Test
    void read() {
        var teachClass = repository.read(teacherClass.getTeacherID());
        assertAll(
                () -> assertNotNull(teacherClass),
                () -> assertEquals(teacherClass.getTeacherID(), teachClass.getTeacherID()),
                () -> assertEquals(teacherClass.getRoomID(), teachClass.getRoomID())
        );
    }

    @Test
    void update() {
        TeacherClass teachClass = new TeacherClass.Builder().copy(teacherClass).setRoomID("6").build();
        var updateTeachClass = repository.update(teachClass);
        assertAll(
                () -> assertNotNull(updateTeachClass),
                () -> assertEquals(teachClass.getTeacherID(), updateTeachClass.getTeacherID()),
                () -> assertEquals(teachClass.getRoomID(), updateTeachClass.getRoomID())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(teacherClass.getTeacherID());
        assertTrue(isDeleted);
    }

    @Test
    void getAllTeacherClass() {
        assertEquals(1, repository.getAllTeacherClass().size());
    }

    @Test
    void contains() {
        var readTeacherClass = repository.read(teacherClass.getTeacherID());
        assertNotNull(readTeacherClass);
    }

}