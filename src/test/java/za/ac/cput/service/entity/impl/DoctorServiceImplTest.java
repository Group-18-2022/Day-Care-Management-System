package za.ac.cput.service.entity.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.factory.entity.DoctorFactory;
import za.ac.cput.repository.entity.IDoctorRepository;
import za.ac.cput.service.entity.DoctorService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorServiceImplTest {

    private Doctor doctor;
    @Autowired
    private DoctorServiceImpl service;
    @Autowired @Mock
    private IDoctorRepository repository;

    @BeforeEach
    void setUp() {
        this.doctor = DoctorFactory.buildDoctor("test-id", "TT Practice Name", "John", "Smith", "0123455678");
        this.service = new DoctorServiceImpl(this.repository);
        Doctor saved = this.service.save(this.doctor);
        assertEquals(this.doctor, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.doctor);
        List<Doctor> employeeList = this.service.findAll();
        assertEquals(0, employeeList.size());
    }

    @Test
    void read() {
        Optional<Doctor> read = this.service.read(doctor.getDoctorID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(doctor, read.get())
        );
    }

    @Test
    void findByDoctorID() {
        List<Doctor> doctorList = this.service.findAll();
        assertEquals(1, doctorList.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(doctor.getDoctorID());
        List<Doctor> doctorsList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, doctorsList.size())
        );
    }
}