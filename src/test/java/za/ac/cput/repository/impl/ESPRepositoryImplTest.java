package za.ac.cput.repository.impl;

/* ESPRepositoryImplTest.java
   Test for the Emergency Service Provider Repository
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.factory.lookup.ESPFactory;
import za.ac.cput.repository.impl.lookup.ESPRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ESPRepositoryImplTest {
    private static ESPRepositoryImpl repository
            = ESPRepositoryImpl.getRepository();
    private static EmergencyServiceProvider esp
            = ESPFactory.createESP("Medical assistance", "Medical", "072 146 0715");

    @Test
    void create() {
        EmergencyServiceProvider created = repository.create(esp);
        assertEquals(esp.getServiceID(), created.getServiceID());
        System.out.println("Create: "+created);
    }

    @Test
    void read() {
        EmergencyServiceProvider read = repository.read(esp.getServiceID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void update() {
        EmergencyServiceProvider updated = new
                EmergencyServiceProvider.Builder().copy(esp)
                .setServiceName("Medical assistance")
                .setType("Medical")
                .setPhoneNum("072 146 0715")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void delete() {
        boolean success = repository.delete(esp.getServiceID());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
