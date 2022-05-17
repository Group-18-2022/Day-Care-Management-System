package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Doctor;
import za.ac.cput.factory.user.DoctorFactory;
import za.ac.cput.repository.impl.user.DoctorRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class DoctorRepositoryImplTest {
    private DoctorRepositoryImpl repository;
    private Doctor doctor = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        doctor = DoctorFactory.buildDoctor("Health Clinic", "Peter", "Pan", "098 456 132");
        var doc = repository.create(doctor);
        assertAll(
                () -> assertNotNull(doc),
                () -> assertEquals(doctor.getPracticeName(), doc.getPracticeName()),
                () -> assertEquals(doctor.getFirstName(), doc.getFirstName()),
                () -> assertEquals(doctor.getLastName(), doc.getLastName()),
                () -> assertEquals(doctor.getPhoneNumber(), doc.getPhoneNumber())
        );
    }

    @Test
    void getRepository() {
        assertNotNull(repository);
    }

    @Test
    void read() {
        var doc = repository.read(doctor.getDoctorID());
        assertAll(
                () -> assertNotNull(doc),
                () -> assertEquals(doctor.getPracticeName(), doc.getPracticeName()),
                () -> assertEquals(doctor.getFirstName(), doc.getFirstName()),
                () -> assertEquals(doctor.getLastName(), doc.getLastName()),
                () -> assertEquals(doctor.getPhoneNumber(), doc.getPhoneNumber())
        );
    }

    @Test
    void update() {
        Doctor doc = new Doctor.Builder().copy(doctor).setLastName("Panic").build();
        var updateDoc = repository.update(doc);
        assertAll(
                () -> assertNotNull(updateDoc),
                () -> assertEquals(doc.getPracticeName(), updateDoc.getPracticeName()),
                () -> assertEquals(doc.getFirstName(), updateDoc.getFirstName()),
                () -> assertEquals(doc.getLastName(), updateDoc.getLastName()),
                () -> assertEquals(doc.getPhoneNumber(), updateDoc.getPhoneNumber())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(doctor.getDoctorID());
        assertTrue(isDeleted);
    }

    @Test
    void getAllDoctors() {
        assertEquals(1, repository.getAllDoctors().size());
    }

    @Test
    void contains() {
        var readDoc = repository.read(doctor.getDoctorID());
        assertNotNull(readDoc);
    }
}