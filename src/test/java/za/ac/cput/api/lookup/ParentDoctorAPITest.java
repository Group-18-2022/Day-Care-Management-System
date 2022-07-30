package za.ac.cput.api.lookup;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.entity.DoctorFactory;
import za.ac.cput.factory.entity.ParentFactory;
import za.ac.cput.factory.lookup.ParentDoctorFactory;
import za.ac.cput.service.entity.impl.DoctorServiceImpl;
import za.ac.cput.service.entity.impl.ParentServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParentDoctorAPITest {

    @Autowired
    private ParentServiceImpl parentService;
    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    private ParentDoctorAPI parentDoctorAPI;

    private Parent parent;
    private Doctor doctor;
    private ParentDoctor parentDoctor;

    @BeforeEach
    public void startUp(){
        this.parent = ParentFactory.buildParent("1", "Tester", "Last Name Tester", "123 Test Street", "0987654321");
        this.doctor = DoctorFactory.buildDoctor("1", "Tester", "Last Name Tester", "Last Name Test", "0987654321");
        this.parentDoctor = ParentDoctorFactory.buildParentDoctor("1", "1");
    }

    @Test
    @Order(1)
    void invalidParentDoctorShouldThrowException() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            this.parentDoctorAPI.save(this.parentDoctor);
        });

        String expectedMessage = "Doctor Not Found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(2)
    void save() {
        this.doctorService.save(doctor);
        this.parentService.save(parent);
        ParentDoctor saved = this.parentDoctorAPI.save(this.parentDoctor);
        assertNotNull(saved);
    }
}