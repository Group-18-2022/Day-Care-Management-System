package za.ac.cput.repository.impl;

/* SecretaryRepositoryImplTest.java
   Test for the Secretary Repository
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Secretary;
import za.ac.cput.factory.user.SecretaryFactory;
import za.ac.cput.repository.impl.user.SecretaryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SecretaryRepositoryImplTest {
    private static SecretaryRepositoryImpl repository
            = SecretaryRepositoryImpl.getRepository();
    private static Secretary secretary
            = SecretaryFactory.createSecretary("Chandre", "de Kock", "27/10/1994");

    @Test
    void create() {
        Secretary created = repository.create(secretary);
        assertEquals(secretary.getSecretaryID(), created.getSecretaryID());
        System.out.println("Create: "+created);
    }

    @Test
    void read() {
        Secretary read = repository.read(secretary.getSecretaryID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void update() {
        Secretary updated = new
                Secretary.Builder().copy(secretary)
                .setFirstName("Chandre")
                .setLastName("de Kock")
                .setDob("27/10/1994")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void delete() {
        boolean success = repository.delete(secretary.getSecretaryID());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
