package za.ac.cput.service.user.Impl;

/* SecretaryServiceImplTest.java
   Service Implementation Test for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.Secretary;
import za.ac.cput.factory.user.SecretaryFactory;
import za.ac.cput.repository.ISecretaryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecretaryServiceImplTest {

    private Secretary secretary;
    @Autowired
    private ISecretaryRepository repository;
    @Autowired
    private SecretaryServiceImpl service;

    @BeforeEach
    void setUp() {
        this.secretary = SecretaryFactory.createSecretary("R10", "Ronaldinho", "Gaucho", "1980/08/05");
        Secretary saved = this.service.save(this.secretary);
        assertEquals(this.secretary, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.secretary);
        List<Secretary> secretaryList = this.service.findAll();
        assertEquals(0, secretaryList.size());
    }

    @Test
    void save() {
        Secretary saveSecretary = this.service.save(this.secretary);
        assertEquals(this.secretary, saveSecretary);
    }

    @Test
    void read() {
        Optional<Secretary> read = this.service.read(secretary.getSecretaryID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(secretary, read.get())
        );
    }

    @Test
    void delete() {
        this.service.delete(this.secretary);
        this.service.findAll();
    }

    @Test
    void deleteByID() {
        this.service.deleteByID(secretary.getSecretaryID());
        List<Secretary> secretaryList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, secretaryList.size())
        );
    }
}