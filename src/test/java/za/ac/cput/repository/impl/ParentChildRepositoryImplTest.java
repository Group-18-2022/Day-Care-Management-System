package za.ac.cput.repository.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.factory.lookup.ParentChildFactory;
import za.ac.cput.repository.impl.lookup.ParentChildRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

class ParentChildRepositoryImplTest {
    private ParentChildRepositoryImpl repository;
    private ParentChild parentChild = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        parentChild = ParentChildFactory.buildParentChild("1", "1");
        var parChild = repository.create(parentChild);
        assertAll(
                () -> assertNotNull(parChild),
                () -> assertEquals(parentChild.getParentID(), parChild.getParentID()),
                () -> assertEquals(parentChild.getChildID(), parChild.getChildID())
        );
    }

    @AfterEach
    void tearDown() {
        var parentChildDB = repository.getAllParentChild();
        parentChildDB.removeAll(parentChildDB);
    }

    @Test
    void getRepository() { assertNotNull(repository); }

    @Test
    void read() {
        var parChild = repository.read(parentChild.getParentID());
        assertAll(
                () -> assertNotNull(parChild),
                () -> assertEquals(parentChild.getParentID(), parChild.getParentID()),
                () -> assertEquals(parentChild.getChildID(), parChild.getChildID())
        );
    }

    @Test
    void update() {
        ParentChild parChild = new ParentChild.Builder().copy(parentChild).setChildID("2").build();
        var updateParChild = repository.update(parChild);
        assertAll(
                () -> assertNotNull(updateParChild),
                () -> assertEquals(parChild.getParentID(), updateParChild.getParentID()),
                () -> assertEquals(parChild.getChildID(), updateParChild.getChildID())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(parentChild.getParentID());
        assertTrue(isDeleted);
    }

    @Test
    void getAllParentChild() {
        assertEquals(1, repository.getAllParentChild().size());
    }

    @Test
    void contains() {
        var readParentChild = repository.read(parentChild.getParentID());
        assertNotNull(readParentChild);
    }
}