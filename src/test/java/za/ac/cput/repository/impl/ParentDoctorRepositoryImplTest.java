package za.ac.cput.repository.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.lookup.ParentDoctorFactory;
import za.ac.cput.repository.impl.lookup.ParentDoctorRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class ParentDoctorRepositoryImplTest {
    private ParentDoctorRepositoryImpl repository;
    private ParentDoctor parentDoctor = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        parentDoctor = ParentDoctorFactory.buildParentDoctor("1", "1");
        var create = repository.create(parentDoctor);
        assertAll(
                () -> assertNotNull(create),
                () -> assertEquals(parentDoctor.getDoctorID(), create.getDoctorID()),
                () -> assertEquals(parentDoctor.getParentID(), create.getParentID())
        );
    }

    @AfterEach
    void tearDown() {
        var parentDoctorDB = repository.getAllParentDoctors();
        parentDoctorDB.removeAll(parentDoctorDB);
    }

    @Test
    void getRepository() {
        assertNotNull(repository);
    }

    @Test
    void read() {
        var parDoc = repository.read(parentDoctor.getParentID());
        assertAll(
                () -> assertNotNull(parDoc),
                () -> assertEquals(parentDoctor.getDoctorID(), parDoc.getDoctorID()),
                () -> assertEquals(parentDoctor.getParentID(), parDoc.getParentID())
        );
    }

    @Test
    void update() {
        ParentDoctor parDoc = new ParentDoctor.Builder().copy(parentDoctor).setDoctorID("2").build();
        var updateDoc = repository.update(parDoc);
        assertAll(
                () -> assertNotNull(updateDoc),
                () -> assertEquals(updateDoc.getDoctorID(), parDoc.getDoctorID()),
                () -> assertEquals(updateDoc.getParentID(), parDoc.getParentID())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(parentDoctor.getParentID());
        assertTrue(isDeleted);
    }

    @Test
    void getAllParentDoctors() {
        assertEquals(1, repository.getAllParentDoctors().size());
    }

    @Test
    void contains() {
        var readDoc = repository.read(parentDoctor.getDoctorID());
        assertNotNull(readDoc);
    }
}