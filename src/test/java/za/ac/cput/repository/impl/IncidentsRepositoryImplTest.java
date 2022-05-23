package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Doctor;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.factory.user.DoctorFactory;
import za.ac.cput.factory.user.IncidentsFactory;
import za.ac.cput.repository.impl.user.DoctorRepositoryImpl;
import za.ac.cput.repository.impl.user.IncidentsRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class IncidentsRepositoryImplTest {
    private IncidentsRepositoryImpl repository;
    private Incidents incidents = null;

    @BeforeEach
    void setUp() {
        repository = repository.getRepository();
        incidents = IncidentsFactory.build("13", "14", "15", "12/2/22", "Cape Town", "Broken Finger");
        var inci = repository.create(incidents);
        assertAll(
                () -> assertNotNull(inci),
                () -> assertEquals(incidents.getIncidentID(), inci.getIncidentID()),
                () -> assertEquals(incidents.getTeacherID(), inci.getTeacherID()),
                () -> assertEquals(incidents.getChildID(), inci.getChildID()),
                () -> assertEquals(incidents.getDate(), inci.getDate()),
                () -> assertEquals(incidents.getLocation(), inci.getLocation()),
                () -> assertEquals(incidents.getInjuryDescription(), inci.getInjuryDescription())
        );
    }

    @Test
    void getRepository() {
        assertNotNull(repository);
    }

    @Test
    void read() {
        var inci = repository.read(incidents.getIncidentID());
        assertAll(
                () -> assertNotNull(inci),
                () -> assertEquals(incidents.getIncidentID(), inci.getIncidentID()),
                () -> assertEquals(incidents.getTeacherID(), inci.getTeacherID()),
                () -> assertEquals(incidents.getChildID(), inci.getChildID()),
                () -> assertEquals(incidents.getDate(), inci.getDate()),
                () -> assertEquals(incidents.getLocation(), inci.getLocation()),
                () -> assertEquals(incidents.getInjuryDescription(), inci.getInjuryDescription())
        );
    }

    @Test
    void update() {
        Incidents inci = new Incidents.Builder().copy(incidents).setLocation("Durban").build();
        var updateIncidents = repository.update(inci);
        assertAll(
                () -> assertNotNull(updateIncidents),
                () -> assertEquals(incidents.getIncidentID(), updateIncidents.getIncidentID()),
                () -> assertEquals(incidents.getTeacherID(), updateIncidents.getTeacherID()),
                () -> assertEquals(incidents.getChildID(), updateIncidents.getChildID()),
                () -> assertEquals(incidents.getDate(), updateIncidents.getDate()),
                () -> assertEquals(incidents.getLocation(), updateIncidents.getLocation()),
                () -> assertEquals(incidents.getInjuryDescription(), updateIncidents.getInjuryDescription())
        );
    }

    @Test
    void delete() {
        var isDeleted = repository.delete(incidents.getIncidentID());
        assertTrue(isDeleted);
    }

    @Test
    void getAllDoctors() {
        assertEquals(1, repository.getAllIncidents().size());
    }

    @Test
    void contains() {
        var readIncidents = repository.read(incidents.getIncidentID());
        assertNotNull(readIncidents);
    }


}