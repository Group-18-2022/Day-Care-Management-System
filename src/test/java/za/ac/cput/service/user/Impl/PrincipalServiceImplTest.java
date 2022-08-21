package za.ac.cput.service.user.Impl;

/* PrincipalServiceImplTest.java
   Service Implementation Test for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.Principal;
import za.ac.cput.factory.user.PrincipalFactory;
import za.ac.cput.repository.IPrincipalRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrincipalServiceImplTest {

    private Principal principal;
    @Autowired
    private IPrincipalRepository repository;
    @Autowired
    private PrincipalServiceImpl service;

    @BeforeEach
    void setUp() {
        this.principal = PrincipalFactory.createPrincipal("R10", "Ronaldinho", "Gaucho", "1980/08/05");
        Principal saved = this.service.save(this.principal);
        assertEquals(this.principal, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.principal);
        List<Principal> principalList = this.service.findAll();
        assertEquals(0, principalList.size());
    }

    @Test
    void save() {
        Principal savePrincipal = this.service.save(this.principal);
        assertEquals(this.principal, savePrincipal);
    }

    @Test
    void read() {
        Optional<Principal> read = this.service.read(principal.getPrincipalID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(principal, read.get())
        );
    }

    @Test
    void delete() {
        this.service.delete(this.principal);
        this.service.findAll();
    }

    @Test
    void deleteByID() {
        this.service.deleteByID(principal.getPrincipalID());
        List<Principal> principalList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, principalList.size())
        );
    }
}