package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.lookup.ParentDoctorFactory;
import za.ac.cput.repository.lookup.IParentDoctorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentDoctorServiceImplTest {
    private ParentDoctor parentDoctor;
    @Autowired
    private ParentDoctorServiceImpl service;
    @Autowired @Mock
    private IParentDoctorRepository repository;

    @BeforeEach
    void setUp() {
        this.parentDoctor = ParentDoctorFactory.buildParentDoctor("test-doctor-id", "test-parent-id");
        this.service = new ParentDoctorServiceImpl(this.repository);
        ParentDoctor saved = this.service.save(this.parentDoctor);
        assertEquals(this.parentDoctor, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.parentDoctor);
        List<ParentDoctor> parentDoctorList = this.service.findAll();
        assertEquals(0, parentDoctorList.size());
    }

    @Test
    void read() {
        Optional<ParentDoctor> read = this.service.read(new ParentDoctor.ParentDoctorID(parentDoctor.getDoctorID(), parentDoctor.getParentID()));
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(parentDoctor, read.get())
        );
    }

    @Test
    void findByParentDoctorID() {
        List<ParentDoctor> parentDoctorList = this.service.findAll();
        assertEquals(1, parentDoctorList.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(new ParentDoctor.ParentDoctorID(parentDoctor.getDoctorID(), parentDoctor.getParentID()));
        List<ParentDoctor> parentDoctorList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, parentDoctorList.size())
        );
    }
}