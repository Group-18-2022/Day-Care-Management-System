package za.ac.cput.repository.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.factory.entity.ParentFactory;
import za.ac.cput.repository.impl.entity.ParentRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class ParentRepositoryImplTest {
    private ParentRepositoryImpl repository;
    private Parent parent = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        parent = ParentFactory.buildParent("Jerry", "Spring", "12 Hudson Street", "082 510 1207");
        var prt = repository.create(parent);
        assertAll(
                () -> assertNotNull(prt),
                () -> assertEquals(parent.getFirstName(), prt.getFirstName()),
                () -> assertEquals(parent.getLastName(), prt.getLastName()),
                () -> assertEquals(parent.getAddress(), prt.getAddress()),
                () -> assertEquals(parent.getPhoneNumber(), prt.getPhoneNumber())
        );
    }

    @AfterEach
    void tearDown() {
        var parentDB = repository.getParents();
        parentDB.removeAll(parentDB);
    }

    @Test
    void getRepository() { assertNotNull(repository);}

    @Test
    void read() {
        var prt = repository.read(parent.getParentID());
        assertAll(
                () -> assertNotNull(prt),
                () -> assertEquals(parent.getFirstName(), prt.getFirstName()),
                () -> assertEquals(parent.getLastName(), prt.getLastName()),
                () -> assertEquals(parent.getAddress(), prt.getAddress()),
                () -> assertEquals(parent.getPhoneNumber(), prt.getPhoneNumber())
        );
    }

    @Test
    void update() {
        Parent prt = new Parent.Builder().copy(parent).setFirstName("Henry").build();
        var updateParent = repository.update(prt);
        assertAll(
                () -> assertNotNull(updateParent),
                () -> assertEquals(prt.getFirstName(), updateParent.getFirstName()),
                () -> assertEquals(prt.getLastName(), updateParent.getLastName()),
                () -> assertEquals(prt.getAddress(), updateParent.getAddress()),
                () -> assertEquals(prt.getPhoneNumber(), updateParent.getPhoneNumber())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(parent.getParentID());
        assertTrue(isDeleted);
    }

    @Test
    void getParents() {
        assertEquals(1, repository.getParents().size());
    }

    @Test
    void contains() {
        var readParent = repository.read(parent.getParentID());
        assertNotNull(readParent);
    }
}