package za.ac.cput.service.lookup.Impl;

/* ESPServiceImplTest.java
   Service Implementation Test for the ESP
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.factory.lookup.ESPFactory;
import za.ac.cput.repository.IESPRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ESPServiceImplTest {

    private EmergencyServiceProvider esp;
    @Autowired
    private IESPRepository repository;
    @Autowired
    private ESPServiceImpl service;

    @BeforeEach
    void setUp() {
        this.esp = ESPFactory.createESP("some-id", "Health", "Medical", "911");
        EmergencyServiceProvider saved = this.service.save(this.esp);
        assertEquals(this.esp, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.esp);
        List<EmergencyServiceProvider> espList = this.service.findAll();
        assertEquals(0, espList.size());
    }

    @Test
    void save() {
        EmergencyServiceProvider saveESP = this.service.save(this.esp);
        assertEquals(this.esp, saveESP);
    }

    @Test
    void read() {
        Optional<EmergencyServiceProvider> read = this.service.read(esp.getServiceID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(esp, read.get())
        );
    }

    @Test
    void delete() {
        this.service.delete(this.esp);
        this.service.findAll();
    }

    @Test
    void deleteByID() {
        this.service.deleteByID(esp.getServiceID());
        List<EmergencyServiceProvider> espList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, espList.size())
        );
    }
}