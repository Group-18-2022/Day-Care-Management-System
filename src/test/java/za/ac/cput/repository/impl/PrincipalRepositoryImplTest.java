package za.ac.cput.repository.impl;

/* PrincipalRepositoryImplTest.java
   Test for the Principal Repository
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Principal;
import za.ac.cput.factory.user.PrincipalFactory;
import za.ac.cput.repository.impl.user.PrincipalRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class PrincipalRepositoryImplTest {
    private static PrincipalRepositoryImpl repository
            = PrincipalRepositoryImpl.getRepository();
    private static Principal principal
            = PrincipalFactory.createPrincipal("Joshua", "Jonkers", "05/08/1996");

    @Test
    void create() {
        Principal created = repository.create(principal);
        assertEquals(principal.getPrincipalID(), created.getPrincipalID());
        System.out.println("Create: "+created);
    }

    @Test
    void read() {
        Principal read = repository.read(principal.getPrincipalID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void update() {
        Principal updated = new
                Principal.Builder().copy(principal)
                .setFirstName("Joshua")
                .setLastName("Jonkers")
                .setDob("05/08/1996")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void delete() {
        boolean success = repository.delete(principal.getPrincipalID());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
